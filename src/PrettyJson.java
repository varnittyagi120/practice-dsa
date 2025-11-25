package src;

public class PrettyJson {
    public static void main(String[] args) {
        String str = "{\"name\":\"John Smith\",\"sku\":\"20223\",\"price\":23.95,\"shipTo\":{\"name\":\"Jane Smith\",\"address\":\"123 Maple Street\",\"city\":\"Pretendville\",\"state\":\"NY\",\"zip\":\"12345\"},\"billTo\":{\"name\":\"John Smith\",\"address\":\"123 Maple Street\",\"city\":\"Pretendville\",\"state\":\"NY\",\"zip\":\"12345\"}}";
        /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(str);

        JSONObject jsonObject = new JSONObject(str);
        String json = jsonObject.toString(4);*/
    }
}
