package org.example.DataSetUtilities
import org.apache.spark.sql.{Dataset, SparkSession}
import org.example.Logger.Logging

import scala.reflect.ClassTag
import org.apache.spark.sql.Encoders

object DataSetLoader extends Logging{
  def LoadDataSet[T](ruta: String)(implicit spark: SparkSession, ctag: ClassTag[T]): Dataset[T] = {
    spark.read
      .option("inferSchema", "true")
      .option("header", "true")
      .csv(ruta)
      .as[T](Encoders.bean(ctag.runtimeClass.asInstanceOf[Class[T]]))
  }
}
