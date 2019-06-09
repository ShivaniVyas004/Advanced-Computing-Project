<%@page import="searche.IndexandSearch"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.Reader"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.lucene.analysis.Analyzer"%>
<%@ page import="org.apache.lucene.analysis.standard.StandardAnalyzer"%>
<%@ page import="org.apache.lucene.document.Document"%>
<%@ page import="org.apache.lucene.document.Field"%>
<%@ page import="org.apache.lucene.index.CorruptIndexException"%>
<%@ page import="org.apache.lucene.index.IndexReader"%>
<%@ page import="org.apache.lucene.index.IndexWriter"%>
<%@ page import="org.apache.lucene.queryParser.MultiFieldQueryParser"%>
<%@ page import="org.apache.lucene.queryParser.ParseException"%>
<%@ page import="org.apache.lucene.queryParser.QueryParser"%>
<%@ page import="org.apache.lucene.search.Hit"%>
<%@ page import="org.apache.lucene.search.Hits"%>
<%@ page import="org.apache.lucene.search.IndexSearcher"%>
<%@ page import="org.apache.lucene.search.Query"%>
<%@ page import="org.apache.lucene.store.Directory"%>
<%@ page import="org.apache.lucene.store.FSDirectory"%>
<%@ page import="org.apache.lucene.store.LockObtainFailedException"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>W3C School Search</title>
</head>
<body>
<form id="searchBox" method="get">
			<input id="search" type="text" name="searchString">
			<input id="submit" type="button" value="Search">
		</form>
		<table>
		<%String sQ = Arrays.toString(request.getParameterValues("searchString"));
		 String searchQuery=sQ.replaceAll("\\[", "").replaceAll("\\]","");
		 IndexandSearch is=new IndexandSearch();
		 /* //String result=is.searchIndex(searchQuery); */
						out.write("Output:<br>");
						out.write("<table class='tableClass'>");
						out.write("<tr>");
						out.write("</tr>");
							out.write("<tr>");
							//out.write("<td class='tableChildClass'>" + result + "</td>");
							out.write("</tr>");
						out.write("</table>");
						%>
						</table>
</body>
</html>