package com.aceandtate

import sttp.client3._
import scala.io.Source

object StockForecastClientApp:
  def main(args: Array[String]): Unit =
    if(args.length == 0) {
      println("Please provide the path of the suppliers xml")
    }
    val filename = args(0)
    val content = Source.fromFile(filename).getLines.mkString

    val request = basicRequest
      .post(uri"http://localhost:8080/suppliers/load")
      .body(content)

    val backend = HttpURLConnectionBackend()
    val response = request.send(backend)

    val resultMessage = if(response.code.code == 205) then
      "Sucessfuly reset state at localhost:8080"
    else
      s"Failure while trying to reset state: status code = ${response.code.code}"

    println(resultMessage)

