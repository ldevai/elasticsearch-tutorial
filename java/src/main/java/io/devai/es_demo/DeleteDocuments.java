package io.devai.es_demo;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;

import java.io.IOException;

public class DeleteDocuments {

    public static void main(String[] args) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        try {
            BoolQueryBuilder boolQuery = QueryBuilders
                    .boolQuery()
                    .should(QueryBuilders.termQuery("name.keyword", "John Doe"));

            DeleteByQueryRequest request = new DeleteByQueryRequest("contacts");
            request.setQuery(boolQuery);
            BulkByScrollResponse response = client.deleteByQuery(request, RequestOptions.DEFAULT);

            System.out.println("Deleted row(s): " + response.getTotal());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
