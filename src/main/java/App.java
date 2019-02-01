import com.datastax.spark.connector.japi.CassandraJavaUtil;
import com.datastax.spark.connector.japi.CassandraRow;
import com.datastax.spark.connector.japi.rdd.CassandraTableScanJavaRDD;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import static com.datastax.driver.core.querybuilder.QueryBuilder.select;
import static com.datastax.spark.connector.japi.CassandraJavaUtil.*;

public class App {

    public static void main(String[] args) {

        SparkConf conf=new SparkConf();
        conf.setAppName("Cassandra-Spark connector.");
        conf.setMaster("local");
        conf.set("spark.cassandra.connection.host", "localhost");

        //RDD
        JavaSparkContext jsc = new JavaSparkContext(conf);
        CassandraTableScanJavaRDD<CassandraRow> cas = javaFunctions(jsc).cassandraTable("essentials", "movies");
        System.out.println(cas.collect().toString());
        jsc.stop();

        //DataSets
        /*SparkContext sc = new SparkContext(conf);
        SparkSession sparkSession=new SparkSession(sc);
        Map<String, String> optSummaryItems = new HashMap<String, String>();
        optSummaryItems.put("keyspace", "essentials");
        optSummaryItems.put("table", "movies");

        Dataset<Row> df = sparkSession.read().format("org.apache.spark.sql.cassandra").options(optSummaryItems).load();

        df.show();
        sparkSession.stop();
        sc.stop();*/



    }
}
