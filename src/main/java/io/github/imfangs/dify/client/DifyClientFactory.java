package io.github.imfangs.dify.client;

import io.github.imfangs.dify.client.impl.DefaultDifyClient;
import io.github.imfangs.dify.client.impl.DefaultDifyDatasetsClient;
import io.github.imfangs.dify.client.model.DifyConfig;
import io.github.imfangs.dify.client.util.HttpClientUtils;
import okhttp3.OkHttpClient;

/**
 * Dify客户端工厂类
 */
public class DifyClientFactory {

    /**
     * 创建完整的Dify客户端
     *
     * @param baseUrl 基础URL
     * @param apiKey  API密钥
     * @return Dify客户端
     */
    public static DifyClient createClient(String baseUrl, String apiKey) {
        return createClient(baseUrl, apiKey, HttpClientUtils.createDefaultClient());
    }

    /**
     * 创建完整的Dify客户端
     *
     * @param baseUrl    基础URL
     * @param apiKey     API密钥
     * @param httpClient HTTP客户端
     * @return Dify客户端
     */
    public static DifyClient createClient(String baseUrl, String apiKey, OkHttpClient httpClient) {
        return new DefaultDifyClient(baseUrl, apiKey, httpClient);
    }

    /**
     * 使用配置创建完整的Dify客户端
     *
     * @param config 配置
     * @return Dify客户端
     */
    public static DifyClient createClient(DifyConfig config) {
        OkHttpClient httpClient = HttpClientUtils.createClient(
                config.getConnectTimeout(),
                config.getReadTimeout(),
                config.getWriteTimeout()
        );
        return new DefaultDifyClient(config.getBaseUrl(), config.getApiKey(), httpClient);
    }

    /**
     * 创建对话型应用客户端
     *
     * @param baseUrl 基础URL
     * @param apiKey  API密钥
     * @return 对话型应用客户端
     */
    public static DifyChatClient createChatClient(String baseUrl, String apiKey) {
        return createClient(baseUrl, apiKey);
    }

    /**
     * 创建工作流编排对话型应用客户端
     *
     * @param baseUrl 基础URL
     * @param apiKey  API密钥
     * @return 工作流编排对话型应用客户端
     */
    public static DifyChatflowClient createChatWorkflowClient(String baseUrl, String apiKey) {
        return createClient(baseUrl, apiKey);
    }

    /**
     * 创建文本生成型应用客户端
     *
     * @param baseUrl 基础URL
     * @param apiKey  API密钥
     * @return 文本生成型应用客户端
     */
    public static DifyCompletionClient createCompletionClient(String baseUrl, String apiKey) {
        return createClient(baseUrl, apiKey);
    }

    /**
     * 创建Workflow应用客户端
     *
     * @param baseUrl 基础URL
     * @param apiKey  API密钥
     * @return Workflow应用客户端
     */
    public static DifyWorkflowClient createWorkflowClient(String baseUrl, String apiKey) {
        return createClient(baseUrl, apiKey);
    }

    /**
     * 创建知识库客户端
     *
     * @param baseUrl 基础URL
     * @param apiKey  API密钥
     * @return 知识库客户端
     */
    public static DifyDatasetsClient createDatasetsClient(String baseUrl, String apiKey) {
        return createDatasetsClient(baseUrl, apiKey, HttpClientUtils.createDefaultClient());
    }

    /**
     * 创建知识库客户端
     *
     * @param baseUrl    基础URL
     * @param apiKey     API密钥
     * @param httpClient HTTP客户端
     * @return 知识库客户端
     */
    public static DifyDatasetsClient createDatasetsClient(String baseUrl, String apiKey, OkHttpClient httpClient) {
        return new DefaultDifyDatasetsClient(baseUrl, apiKey, httpClient);
    }

    /**
     * 使用配置创建知识库客户端
     *
     * @param config 配置
     * @return 知识库客户端
     */
    public static DifyDatasetsClient createDatasetsClient(DifyConfig config) {
        OkHttpClient httpClient = HttpClientUtils.createClient(
                config.getConnectTimeout(),
                config.getReadTimeout(),
                config.getWriteTimeout()
        );
        return new DefaultDifyDatasetsClient(config.getBaseUrl(), config.getApiKey(), httpClient);
    }
}
