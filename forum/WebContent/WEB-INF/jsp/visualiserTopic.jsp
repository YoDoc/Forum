<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>

<body>
	<table class="tablebg" cellspacing="1" width="100%">
		<tbody>
			<tr class="row2">

				<td valign="middle" align="center"><b class="postauthor"> Auteur: ${topic.auteur.login} </b></td>
				
				<td width="100%" height="25">
					<table cellspacing="0" width="100%">
						<tbody>
							<tr>

								<td class="gensmall" width="100%">
									<div style="float: left;">
										&nbsp; <b>Fil de discussion :</b> Mon fil de discussion
									</div>
									<div style="float: right;">
										<b>Posted:</b> Wed Aug 17, 2016 2:12 pm&nbsp;
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>

		<tr class="row2">

			<td class="profile" valign="top">
				<table cellspacing="4" align="center" width="150">

				</table> <span class="postdetails"> <b>Posts:</b> 24
			</span>

			</td>
			<td valign="top">
				<table cellspacing="5" width="100%">
					<tbody>
						<tr>
							<td>
								<div class="postbody">Ceci est une r&eacute;ponse au fil
									de discussion</div> <br clear="all" /> <br />
								<table cellspacing="0" width="100%">
									<tbody>
										<tr valign="middle">
											<td class="gensmall" align="right"></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>

		<tr>
			<td class="spacer" colspan="2" height="1"><img
				src="fichiers/spacer.gif" alt="" width="1" height="1" /></td>
		</tr>
	</table>


</body>
	</html>



<%-- <c:forEach items="${topics}" var="topic">
</c:forEach> --%>
