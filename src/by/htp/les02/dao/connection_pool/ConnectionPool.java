package by.htp.les02.dao.connection_pool;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public final class ConnectionPool {
	private BlockingQueue<Connection> connectionQueue;
	private BlockingQueue<Connection> givenAwayCoQueue;

	private String driverName;
	private String url;
	private String user;
	private String password;
	private int poolSize;

	public ConnectionPool() {
		DBResourceManager dbResourceManager = DBResourceManager.getInstance();
		this.driverName = dbResourceManager.getValue(DBParameter.DB_DRIVER);
		this.url = dbResourceManager.getValue(DBParameter.DB_URL);
		this.user = dbResourceManager.getValue(DBParameter.DB_USER);
		this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);

		try {
			this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POLL_SIZE));
		} catch (NumberFormatException e) {
			poolSize = 5;
		}
	}

	public void initPoolData() throws ConnectionPoolException {

		try {
			Class.forName(driverName);
			givenAwayCoQueue = new ArrayBlockingQueue<Connection>(poolSize);
			connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);

			for (int i = 0; i < poolSize; i++) {
				Connection connection = DriverManager.getConnection(url, user, password);
				PooledConnection pooledConnection = new PooledConnection(connection);
				connectionQueue.add(pooledConnection);
			}
		} catch (SQLException e) {
			throw new ConnectionPoolException("SQLException in ConnectionPool", e);
		} catch (ClassNotFoundException e) {
			throw new ConnectionPoolException("Can't find database driver class", e);
		}
	}

	public void dispose() throws ConnectionPoolException {
		clearConnectionQueue();
	}

	private void clearConnectionQueue() throws ConnectionPoolException {
		try {
			closeConnectionsQueue(givenAwayCoQueue);
			closeConnectionsQueue(connectionQueue);
		} catch (SQLException e) {
			throw new ConnectionPoolException("Close Connection Pool Fail!", e);
		}
	}

	public Connection takeConnection() throws ConnectionPoolException {
		Connection connection = null;

		try {
			connection = connectionQueue.take();
			givenAwayCoQueue.add(connection);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Error connecting to the data source.", e);
		}

		return connection;
	}

	// The First
	public void closeConnection(Connection con, Statement st, ResultSet rs) throws ConnectionPoolException {

		try {
			con.close();
		} catch (Exception e) {
			throw new ConnectionPoolException("resource closing error", e);
		}

		try {
			st.close();
		} catch (Exception e) {
			throw new ConnectionPoolException("resource closing error", e);
		}

		try {
			rs.close();
		} catch (Exception e) {
			throw new ConnectionPoolException("resource closing error", e);
		}
	}

	// Second
	public void closeConnection(Connection con, Statement st) throws ConnectionPoolException {

		try {
			con.close();
		} catch (Exception e) {
			throw new ConnectionPoolException("resource closing error", e);
		}

		try {
			st.close();
		} catch (Exception e) {
			throw new ConnectionPoolException("resource closing error", e);
		}
	}

	// Third
	public void closeConnection(Connection con) throws ConnectionPoolException {

		try {
			con.close();
		} catch (Exception e) {
			throw new ConnectionPoolException("resource closing error", e);
		}
	}

	private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
		Connection connection;
		while ((connection = queue.poll()) != null) {
			if (!connection.getAutoCommit()) {
				connection.commit();
			}
			((PooledConnection) connection).reallyClose();
		}
	}

	// inner private impl class
	private class PooledConnection implements Connection {
		private Connection connection;

		public PooledConnection(Connection c) throws SQLException {
			this.connection = c;
			this.connection.setAutoCommit(true);
		}

		public void reallyClose() throws SQLException {
			connection.close();
		}
		
		
		@Override
		public void clearWarnings() throws SQLException {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void close() throws SQLException {
			// TODO Auto-generated method stub

		}
		
		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Statement createStatement() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PreparedStatement prepareStatement(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CallableStatement prepareCall(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String nativeSQL(String sql) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setAutoCommit(boolean autoCommit) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean getAutoCommit() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void commit() throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public void rollback() throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isClosed() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public DatabaseMetaData getMetaData() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setReadOnly(boolean readOnly) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isReadOnly() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setCatalog(String catalog) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public String getCatalog() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setTransactionIsolation(int level) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public int getTransactionIsolation() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public SQLWarning getWarnings() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, Class<?>> getTypeMap() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setHoldability(int holdability) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public int getHoldability() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Savepoint setSavepoint() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Savepoint setSavepoint(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void rollback(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Clob createClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Blob createBlob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public NClob createNClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SQLXML createSQLXML() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isValid(int timeout) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setClientInfo(String name, String value) throws SQLClientInfoException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setClientInfo(Properties properties) throws SQLClientInfoException {
			// TODO Auto-generated method stub

		}

		@Override
		public String getClientInfo(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Properties getClientInfo() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setSchema(String schema) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public String getSchema() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void abort(Executor executor) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
			// TODO Auto-generated method stub

		}

		@Override
		public int getNetworkTimeout() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}
	}

}
