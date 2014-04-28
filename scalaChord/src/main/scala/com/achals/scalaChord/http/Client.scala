package com.achals.scalaChord.http

import java.net.{Socket, InetAddress}
import com.achals.scalaChord.http.data.HttpRequest
import com.achals.scalaChord.http.data.HttpResponse
import com.achals.scalaChord.http.data.RequestLine
import java.io.OutputStream
import com.achals.scalaChord.http.data.Headers
import java.io.ByteArrayOutputStream

class Client {
	val SEPERATOR : Array[Byte] =" ".getBytes() 
	val CRLF : Array[Byte] = "\r\n".getBytes()
  
	def execute( request : HttpRequest ) : HttpResponse = {
	  val host = this.getHost(request)
	  val port = this.getPort(request)
	  val address = InetAddress.getByName(host);
	  val socket : Socket = new Socket(address, port) 
	  val output: OutputStream = socket.getOutputStream()

	  this.writeRequestLine(request.requestLine, output)
	  this.writeHeaders(request.headers, output)
	  this.writeBody(request.body, output)
	  null;
	}

	private def getHost( request : HttpRequest ) : String = {
	  return request.requestLine.uri;
	}

	private def getPort( request : HttpRequest ) : Integer = {
	  request.requestLine.method match {
	    case "http" => 80
	    case _ => -1
	  }
	}

	private def writeRequestLine( request : RequestLine, output: OutputStream) = {
	  output.write(request.method.getBytes())
	  output.write(SEPERATOR)
	  output.write(request.uri.getBytes())
	  output.write(SEPERATOR)
	  output.write(request.protocolVersion.toString().getBytes())
	  output.write(CRLF)
	}
	
	private def writeHeaders( headers: Headers, output: OutputStream ) = {
		val seperator = headers.HEADER_SEPERATOR
		headers.getHeaders().foreach(header => {
		  output.write(header._1.getBytes())
		  output.write(seperator.getBytes())
		  output.write(header._2.getBytes())
		  output.write(CRLF)
		})
	}
	private def writeBody( body : ByteArrayOutputStream, output:OutputStream ) = {
	  output.write(body.toByteArray())
	}
}