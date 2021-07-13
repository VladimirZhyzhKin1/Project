# News Management

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
   - [Edit of news][7] with subsequent updating in the database;
6. Created [localization][8] in Russian and English.

[1]: https://github.com/VladimirZhyzhKin1/Stock/blob/master/java-servlet-project/First%20Page.png 
[2]: https://i.postimg.cc/K8xXTht6/Registration.png
[3]: https://i.postimg.cc/DyM1xqxc/personal-account-User-page1.png
[4]: https://i.postimg.cc/Zq51fP7j/personal-account-User.png
[5]: https://i.postimg.cc/G2B6RL1y/personal-account-Admin.png
[6]: https://i.postimg.cc/PqV00L0H/selected-news-Admin.png
[7]: https://i.postimg.cc/cLmpMkmr/Edit-selected-news-Admin.png
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

[15]: https://youtu.be/yYipezKHV3s




