<%-- 
    Document   : listjsp
    Created on : Feb 15, 2015, 7:16:13 PM
    Author     : nurul apriyani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
        <title>List Mahasiswa</title>
    </head>
    <body>
        <div class="container">
            <h2>List Mahasiswa</h2>
            <a href="${pageContext.request.contextPath}/addmhs" class="btn btn-primary">Add Record</a><br/><br/>
     
            <table class="table table-striped table-bordered">
                <tr> 
                    <th>No.</th>
                    <th>NPM</th>
                    <th>Nama</th>
                    <th>Tgl Lahir</th>
                    <th>Jenis Kelamin</th>
                    <th>Alamat</th>
                    <th>Action</th>
                </tr>
                <% int i=1;%>
                
           <s:iterator value="listmhs" status="stat">
                <tr>
                    <td><% out.print(""+i++);%></td>
                    <td><s:property value="npm"/></td>
                    <td> <s:property value="nama"/> </td>
                    <td> <s:property value="tgl_lahir"/> </td>
                    <td> <s:property value="jk"/></td>
                    <td> <s:property value="alamat"/> </td>
                    <td> <a href="editmhs?id=<s:property value="id"/>"/> Edit</a>
                        <s:url id="url" action="deletemhs?id=%{id}"> </s:url>
                        <s:a href="%{url}" onclick="return confirm('do you really want to delete this record?')" style="color:red">Delete</s:a>  
                   
                    </td>
                </tr>
            </s:iterator>
            </table>
        </div>
    </body>
</html>
