<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Sign up</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white font-family-karla h-screen">

<div class="w-full flex flex-wrap">

    <!-- Login Section -->
    <div class="w-full md:w-1/2 flex flex-col">

        <div class="flex justify-center md:justify-start pt-12 md:pl-12 md:-mb-24">
            <a href="#" class="bg-black text-white font-bold text-xl p-4">Logo</a>
        </div>

        <div class="flex flex-col justify-center md:justify-start my-auto pt-8 md:pt-0 px-8 md:px-24 lg:px-32">
            <p class="text-center text-3xl">Welcome.</p>
            <form action="signup" method="post" class="flex flex-col pt-3 md:pt-8">
                <div class="flex flex-col pt-4">
                    <label for="email" class="text-lg">Email</label>
                    <input type="email" id="email" name="email" placeholder="your@email.com" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mt-1 leading-tight focus:outline-none focus:shadow-outline">
                </div>

                <div class="flex flex-col pt-4">
                    <label for="username" class="text-lg">Username</label>
                    <input type="text" id="username" name="username" placeholder="xyz123" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mt-1 leading-tight focus:outline-none focus:shadow-outline">
                </div>

                <div class="flex flex-col pt-4">
                    <label for="firstname" class="text-lg">First Name</label>
                    <input type="text" id="firstname" name="firstname" placeholder="First Name" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mt-1 leading-tight focus:outline-none focus:shadow-outline">
                </div>

                <div class="flex flex-col pt-4">
                    <label for="lastname" class="text-lg">Last Name</label>
                    <input type="text" id="lastname" name= "lastname" placeholder="Last Name" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mt-1 leading-tight focus:outline-none focus:shadow-outline">
                </div>

                <div class="flex flex-col pt-4">
                    <label for="dob" class="text-lg">Date of Birth</label>
                    <input type="date" id="dob" name="dob" placeholder="mm/dd/yyyy" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mt-1 leading-tight focus:outline-none focus:shadow-outline">
                </div>

                <div class="flex flex-col pt-4">
                    <label for="password" class="text-lg">Password</label>
                    <input type="password" id="password" name="password" placeholder="Password" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mt-1 leading-tight focus:outline-none focus:shadow-outline">
                </div>

                <input type="submit" value="Sign UP" class="bg-black text-white font-bold text-lg hover:bg-gray-700 p-2 mt-8">
            </form>
            <div class="text-center pt-12 pb-12">
                <p>Don't have an account? <a href="login.jsp" class="underline font-semibold">Login Here.</a></p>
            </div>
            <p>
                <%
                    if (request.getSession().getAttribute("success") != null) {
                        String msg = request.getSession().getAttribute("success").toString();
                        out.println(msg);
                    }
                %>
            </p>


        </div>

    </div>

    <!-- Image Section -->
    <div class="w-1/2 shadow-2xl">
        <img class="object-cover w-full h-screen hidden md:block" src="https://source.unsplash.com/IXUM4cJynP0" alt="">
    </div>
</div>

</body>
</html>
