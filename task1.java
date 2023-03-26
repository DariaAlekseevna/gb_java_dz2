/**
 * task1
 * 
 * Дана строка sql-запроса "select * from students where ". 
 * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
 * Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class task1 {

    public static void main(String[] args) {
        String SqlQuery = "select * from students where ";
        String TextJson = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        // System.out.println(TextJson);
        StringBuilder builder = new StringBuilder();
        builder.append(SqlQuery).append(GetSqlWhere(TextJson));
        System.out.println(builder.toString());
    }

    private static String GetSqlWhere(String TextJson) {

        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < TextJson.length()-1; i++) {
            if (TextJson.charAt(i) != '"')
                builder.append(TextJson.charAt(i));
            if (TextJson.charAt(i) == ':')
                builder.replace(builder.length()-1,builder.length(), " = '");
            if (TextJson.charAt(i) == ',')
                builder.replace(builder.length()-1,builder.length(), "' and");
            if (i == TextJson.length()-2)
                builder.append("'");
        }

        StringBuilder builderResult = builder;
        boolean flag = true;
        int pos = builder.indexOf("null");
        if (pos != -1) {
            for (int i = (pos-2); i >= 0; i--) {
                if ((flag == true) && (builder.charAt(i) != '\''))
                    builderResult.deleteCharAt(i);
                else flag = false;
            }
        builderResult.delete(builderResult.indexOf("null")-1, builderResult.indexOf("null")+5);
        }
        return builderResult.toString();
    }
}