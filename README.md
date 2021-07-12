# News Manager

## Description
Web project for posting / viewing news.</br>
The first page shows the latest news, which are posted in the database.</br>
</br>
![Image alt][1]</br>
</br>
The following functionality is also implemented:</br>
1. [Registration Page][2] of new users on the site.
2. Login all participants.
3. Depending on the role, a personal account has been created for both the user([page #1][3] and [page #2][4]) and the [administrator][5].
4. User capabilities:
   - viewing all the news on the site;
   - one selected news in more detail.
5. [Personal account Administrator][6] (capabilities):
   - add new news to the database;
   - remove of news from the database;
   - [Edite of news][7] with subsequent updating in the database;
6. Created [internalization][8] in Russian and English.

[1]: https://github.com/VladimirZhyzhKin1/Stock/blob/master/java-servlet-project/First%20Page.png
[2]: https://i.postimg.cc/K8xXTht6/Registration.png
[3]: https://drive.google.com/file/d/1FKjBangs75hV6HZnIyn_O8jwz2uCzJSW/view?usp=sharing
[4]: https://drive.google.com/file/d/18QnZRH13a7_X84IBR6Rz9N5lrOD73JCM/view?usp=sharing
[5]: https://drive.google.com/file/d/1njSQvLkwVzf0q5nvfk-_txdbOFc9vftK/view?usp=sharing
[6]: https://drive.google.com/file/d/1nEVyTi1x_QrQN8RNxC59u6IDSgRyo9iH/view?usp=sharing
[7]: https://drive.google.com/file/d/1N9dRidBlK93RkUa8FqEsCeQMyLk5DWSq/view?usp=sharing
[8]: https://github.com/VladimirZhyzhKin1/jd2-servlet-project/blob/main/src/by/htp/les02/controller/command/impl/ChangeLocal.java

## Structure
Web application is built on MVC principle of using Layered Architecture
a request from a client comes to 
which then dispatches to which controller to send the given request
Dividing the application system into layers:</br>
- [Beans][9];
- [View][10];
- [Controller][11];
- [Service][12];
- [DAO][13];
- Data Source;

[9]: https://github.com/VladimirZhyzhKin1/jd2-servlet-project/tree/main/src/by/htp/les02/bean
[11]: https://github.com/VladimirZhyzhKin1/jd2-servlet-project/tree/main/src/by/htp/les02/controller
[10]: https://github.com/VladimirZhyzhKin1/jd2-servlet-project/tree/main/WebContent/WEB-INF/jsp
[12]: https://github.com/VladimirZhyzhKin1/jd2-servlet-project/tree/main/src/by/htp/les02/service
[13]: https://github.com/VladimirZhyzhKin1/jd2-servlet-project/tree/main/src/by/htp/les02/dao

The connection to the database is made using JDBC and the created [Сonnection pool][14].

[14]: https://github.com/VladimirZhyzhKin1/jd2-servlet-project/tree/main/src/by/htp/les02/dao/connection_pool

## Technologies
### Used Technologies:
- Java 8
- Java Servlet
- JDBC
- SQL
- MySQL
- HTML5/CSS3
- JSP/JSTL


## Link on the project
Here Link on the project ["News Management"][15] in life.

[15]: https://drive.google.com/file/d/1N9dRidBlK93RkUa8FqEsCeQMyLk5DWSq/view?usp=sharing




