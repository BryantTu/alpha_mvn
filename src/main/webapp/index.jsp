<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student management</title>
</head>
<body>
	<form name="studentForm" method="post">

		<c:if test="${stdList!=null}">
			<table border="1" width="100%" align="center">
				<tr>
					<td align="center"><input type="checkbox" name="selectedAll"
						onclick="selectAll(this,'selectedStudents');"></td>
					<td align="center"><a href="#" onclick="viewAll()">student
							no</a></td>
					<td align="center">student name</td>
				</tr>
				<c:forEach items="${stdList}" var="student">
					<tr>
						<TD valign="top" align="center"><input type="checkbox"
							name="selectedStudents" value="${student.studentNo}"></TD>
						<td align="center"><span style="CURSOR: HAND"
							onclick="
			javascript: window.open('${pageContext.request.contextPath}/prepareUpdStudent.action?studentId=${student.studentNo}','studentUpdate')
		">
								<u>${student.studentNo}</u>
						</span></td>
						<td align="center">${student.studentName}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" align="right"><input type="button"
						value="add students" onclick="popAddStudent();"> <input
						type="button" value="delete students" onclick="del();"></td>
				</tr>
			</table>
		</c:if>
		<input type="hidden" name="order" id="order" value="0" />
	</form>
	<script language="JavaScript">
		function popAddStudent() {
			window
					.open(
							'${pageContext.request.contextPath}/jsp/student/studentAdd.jsp',
							'studentAdd');
		}
		function del() {
			var el = document.getElementsByTagName('input');
			var len = el.length;
			var pc = 0;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox")
						&& (el[i].name == "selectedStudents")) {
					if (el[i].checked) {
						pc++;
					}
				}
			}
			if (pc < 1) {
				alert('Pls select a student to delete');
			} else {
				document.studentForm.action = "${pageContext.request.contextPath}/index.do?method=delete";
				document.studentForm.submit();
			}
		}
		
		function selectAll(obj, name) {
			if (obj.checked == true) {
				checkAll(name);
			} else {
				clearAll(name);
			}
		}
		function checkAll(name) {
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == name)) {
					el[i].checked = true;
				}
			}
		}
		function clearAll(name) {
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == name)) {
					el[i].checked = false;
				}
			}
		}
		
		function viewAll()
		{
			document.studentForm.action = "${pageContext.request.contextPath}/index.do";
			document.studentForm.submit();
		}
	</script>

</body>
</html>