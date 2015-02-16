<%-- 
    Document   : editmhs
    Created on : Feb 16, 2015, 8:05:56 PM
    Author     : nurul apriyani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
        <title>Edit Mahasiswa</title>
    </head>
    <body>
        <div width="500px" align="center">
            <h2>Edit Data</h2>
             <a href="${pageContext.request.contextPath}/listmhs"  class="btn">List Mahasiswa</a><br/></br/>
            <% if(request.getAttribute("msg")!=null)out.print("<div class='alert alert-success' role='alert'>"+(String)request.getAttribute("msg")+"</div>");%>
            <s:form method="post" action="editmhs">
                <s:push value="mhs">
                     <s:hidden name="mhs.id"/>
                    <s:textfield name="mhs.npm" label="NPM"/>
                    <s:textfield name="mhs.nama" label="Nama" />
                    <s:textfield name="mhs.tgl_lahir" type="date" label="Tanggal" />
                    <s:radio name="mhs.jk"  list="{'P','L'}" label="Jenis Kelamin" />
                    <s:textarea name="mhs.alamat" label="Alamat" />
                    <s:submit  class="btn btn-primary" name="action"/>
                </s:push>
            </s:form>
        </div>
    </body>
</html>
