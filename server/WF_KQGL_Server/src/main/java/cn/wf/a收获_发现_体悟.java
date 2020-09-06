//发现：
// 1.关于时间转换
//              数据库设计表，时间类型为        timestamp
//              前端发送String类型的语句，如  20200424.2107
//              数据以string类型传到数据库，
//              会自动转换为时间的形式    即  2020-4-24 21：07
//2.isELIgnored="false",jsp页面的这个，可以使遍历时的${studentchatongzhi.starttime}消失，有数据才会出现应有数据
//3.<c:forEach items="${chabenban}" var="chabenban">
//注意items="${chabenban}"要加${}

//4.卧槽