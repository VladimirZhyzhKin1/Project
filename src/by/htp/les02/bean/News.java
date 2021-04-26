package by.htp.les02.bean;

import java.io.Serializable;

public class News implements Serializable {

	private static final long serialVersionUID = 5421029433949953632L;

	private int idnews;
	private String title;
	private String brief;
	private String data;
	private String content;
	private String status;

	public News() {
	}

	public News(int idnews, String title, String brief, String data, String content, String status) {
		super();
		this.idnews = idnews;
		this.title = title;
		this.brief = brief;
		this.data = data;
		this.content = content;
		this.status = status;
	}

	public News(int idnews, String title, String brief) {
		super();
		this.idnews = idnews;
		this.title = title;
		this.brief = brief;
	}
	

	public News(int idnews, String title, String brief, String content) {
		super();
		this.idnews = idnews;
		this.title = title;
		this.brief = brief;
		this.content = content;
	}

	public int getIdnews() {
		return idnews;
	}

	public void setIdnews(int idnews) {
		this.idnews = idnews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + idnews;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		News other = (News) obj;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idnews != other.idnews)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + this.idnews + "\n" + "title:" + this.title + "\n" + "brief:" + this.brief + "\n" + "content: "
				+ this.content + "\n" + "date: " + this.data + "\n" + "status: " + this.status;
	}

}
