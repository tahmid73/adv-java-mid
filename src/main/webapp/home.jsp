<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
    String id = request.getParameter("userId");
    String driverName = "com.mysql.cj.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String dbName = "social";
    String userId = "root";
    String password = "admin";

    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try{
        connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
        statement=connection.createStatement();
        String sql ="SELECT * FROM status";

        resultSet = statement.executeQuery(sql);
%>

<div class="w-full flex flex-row flex-wrap">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        .round {
            border-radius: 50%;
        }
    </style>


    <div class="w-full bg-indigo-100 h-screen flex flex-row flex-wrap justify-center ">

        <!-- Begin Navbar -->

        <div class="bg-white shadow-lg border-t-4 border-indigo-500 absolute bottom-0 w-full md:w-0 md:hidden flex flex-row flex-wrap">
            <div class="w-full text-right"><button class="p-2 fa fa-bars text-4xl text-gray-600"></button></div>
        </div>

        <div class="w-0 md:w-1/4 lg:w-1/5 h-0 md:h-screen overflow-y-hidden bg-white shadow-lg">
            <div class="p-5 bg-white sticky top-0">
                <img class="border border-indigo-100 shadow-lg round" src="http://lilithaengineering.co.za/wp-content/uploads/2017/08/person-placeholder.jpg">
                <div class="pt-2 border-t mt-5 w-full text-center text-xl text-gray-600">
                    <%
                        if(request.getSession().getAttribute("email")!=null){
                            String msg= request.getSession().getAttribute("email").toString();
                            out.println(msg);
                        }
//                        if(!request.getSession().getAttribute("id").equals('0') ){
//                            String msg= request.getSession().getAttribute("id").toString();
//                            out.println(msg);
//                        }
                    %>
                </div>
            </div>
            <div class="w-full h-screen antialiased flex flex-col hover:cursor-pointer">
                <a href="profile.jsp" class="hover:bg-gray-300 bg-gray-200 border-t-2 p-3 w-full text-xl text-left text-gray-600 font-semibold" ><i class="fa fa-cog text-gray-600 text-2xl pr-1 pt-1 float-right"></i>Settings</a>
                <a href="logout" class="hover:bg-gray-300 bg-gray-200 border-t-2 p-3 w-full text-xl text-left text-gray-600 font-semibold" ><i class="fa fa-arrow-left text-gray-600 text-2xl pr-1 pt-1 float-right"></i>Log out</a>
            </div>
        </div>

        <!-- End Navbar -->

        <div class="w-full md:w-3/4 lg:w-4/5 p-5 md:px-12 lg:24 h-full overflow-x-scroll antialiased">
            <form action="statusPost" method="post">
            <div class="bg-white w-full shadow rounded-lg p-5">
                <textarea name="statusUpdates" id="statusUpdates" class="bg-gray-200 w-full rounded-lg shadow border p-2" rows="5" placeholder="Speak your mind"></textarea>

                <div class="w-full flex flex-row flex-wrap mt-3">
                    <div class="w-1/3">
                    </div>
                    <div class="w-2/3">
                        <input type="submit" value="Post" class="float-right bg-indigo-400 hover:bg-indigo-300 text-white p-2 rounded-lg">
                    </div>
                </div>
            </div>
            </form>

            <div class="mt-3 flex flex-col">
                <%
                while(resultSet.next()){
                %>
                <tr>

                    <div class="bg-white mt-3">
                        <div class="bg-white border shadow p-5 text-xl text-gray-700 font-semibold">
                            <%=resultSet.getString("status")%>
                        </div>
                        <div class="bg-white p-1 border shadow flex flex-row flex-wrap">
                            <div class="w-1/3 hover:bg-gray-200 text-center text-xl text-gray-700 font-semibold"><%=resultSet.getString("likes")%>Like</div>
                            <div class="w-1/3 hover:bg-gray-200 border-l-4 border-r- text-center text-xl text-gray-700 font-semibold">Share</div>
                            <div class="w-1/3 hover:bg-gray-200 border-l-4 text-center text-xl text-gray-700 font-semibold">Comment</div>
                        </div>

                        <div class="bg-white border-4 bg-gray-300 border-white rounded-b-lg shadow p-5 text-xl text-gray-700 content-center font-semibold flex flex-row flex-wrap">
                            <div class="w-full">
                                <div class="w-full text-left text-xl text-gray-600">
                                    <%=resultSet.getString("id")%>>
                                </div>
                            </div>
                        </div>
                    </div>

                </tr>

                <%
                    }

                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                %>
            </div>
        </div>
    </div>

</div>