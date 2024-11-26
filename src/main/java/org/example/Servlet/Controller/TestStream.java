package org.example.Servlet.Controller;

import org.example.Servlet.Models.*;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");

    private List<Transaction> transactionList = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    //TODO ... 待添加的方法...

    @Test
    void test_01 () {
        /*
        * 找出2011年发生的所有交易，并按交易额排序（从高到低）。
        * */
        List<Transaction> copy = transactionList.stream().filter(x->x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        List<Transaction> list = transactionList.stream()
                .filter(item -> item.getYear().equals(2011))
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    void test_02 () {
        /*
         * 交易员都在哪些不同的城市工作过？
         * */

        List<String> city = transactionList.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());

        List<String> list = transactionList.stream()
                .map(Transaction::getTrader).map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    void test_03 () {
        /*
         * 查找所有来自Cambridge的交易员，并按姓名排序。
         * */
        List<Trader> mermber = transactionList.stream().map(Transaction::getTrader)
                .filter(x->x.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());

        List<Trader> list = transactionList.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    void test_04 () {
        /*
         * 返回所有交易员的姓名字符串，按字母顺序排序。
         * */
        List<String> names = transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        //one
        List<String> list = transactionList.stream()
                .map(Transaction::getTrader).map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(list);

        //two
        String concatStr = transactionList.stream()
                .map(Transaction::getTrader).map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .reduce("", String::concat);
        System.out.println(concatStr);

        //three
        concatStr = transactionList.stream()
                .map(Transaction::getTrader).map(Trader::getName)
                .distinct()
                .flatMap(this::filterCharacter)
                .sorted(String::compareTo)
                .reduce("", String::concat);
        System.out.println(concatStr);

    }
    /**
     * 将字符串拆分，一个字符为一个字符串的流。
     */
    private java.util.stream.Stream<String> filterCharacter(String str) {
        List<String> chlist = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chlist.add(String.valueOf(ch));
        }
        return chlist.stream();
    }

    @Test
    void test_05 () {
        /*
         * 有没有交易员在Milan工作。
         * */
        List<Trader> list = transactionList.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(item -> item.getCity().equals("Milan"))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    void test_06 () {
        /*
         * 打印生活在Cambridge的交易员的所有交易额。
         * */
        //one
        Integer sum = transactionList.stream()
                .filter(item -> item.getTrader().getCity().equals("Cambridge")).collect(Collectors.summingInt(Transaction::getValue));
//                .filter(item -> item.getTrader().getCity().equals("Cambridge")).mapToInt(Transaction::getValue).sum();
        System.out.println(sum);

        //two
        sum = transactionList.stream()
                .filter(item -> item.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    void test_07 () {
        /*
         * 所有的交易额中，最高的交易额是多少？
         * */
        //one
        Optional<Integer> max = transactionList.stream()
                .map(Transaction::getValue)
                .collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(max);

        //two
        max = transactionList.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max);
    }

    @Test
    void test_08 () {
        /*
         * 所有的交易额中，找到交易额最小的交易
         * */
        //one
        Optional<Transaction> min = transactionList.stream()
                .min((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        System.out.println(min);

        //two
        min = transactionList.stream()
                .collect(Collectors.minBy((e1, e2) -> e1.getValue().compareTo(e2.getValue())));
        System.out.println(min);
    }

    public static void main(String[] Args){
        TestStream mainApp = new TestStream();
        mainApp.test_01();

        //1.请使用 Java Stream 实现将 List 转换为 Map，key 是字符串的长度，value 是该长度的字符串列表
        List<String> stringList = Arrays.asList("aa","bbb","uuuuuuuu","cccd","dddef","oo");
        Map<Integer,List<String>> lengths = stringList.stream().collect(Collectors.groupingBy(String::length));

        Map<Integer,List<String>> map = stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("请使用 Java Stream 实现将 List 转换为 Map，key 是字符串的长度，value 是该长度的字符串列表:" + map);

        //2.请使用 Java Stream 实现过滤出 List 中所有大于等于 10 的元素
        List<Integer> list= Arrays.asList(1,3,5,10,11,45,25);
        List<Integer> biggerTen = list.stream().filter(x-> x>= 10).collect(Collectors.toList());



        List<Integer> res = list.stream().filter(item -> item >= 10).collect(Collectors.toList());
        System.out.println("请使用 Java Stream 实现过滤出 List 中所有大于等于 10 的元素:" + res);

        //3.请使用 Java Stream 合并两个 List，去重，然后升序排列
        List<Integer> a= Arrays.asList(1,5,2);
        List<Integer> b= Arrays.asList(2,6,3,10,5);
        List<Integer> merge = Stream.concat(a.stream(),b.stream()).distinct().collect(Collectors.toList());
        System.out.println("请使用 Java Stream 合并两个 List，去重，然后升序排列:" + merge);

        //4.请使用 Java Stream 将 Map 中所有 value 转换为列表
        Map<Integer,Integer> intMap = new HashMap<>();
        intMap.put(1,10);
        intMap.put(2,20);
        intMap.put(3,30);
        List<Integer> change = new ArrayList<>(intMap.values());

        List<Integer> values = intMap.values().stream().collect(Collectors.toList());
        System.out.println("请使用 Java Stream 将 Map 中所有 value 转换为列表:" + values);

        //5.请使用 Java Stream 实现对 List 中每个元素进行平方操作
        List<Integer> squaredList = Arrays.asList(1,2,3,4,5);
        List<Integer> doubleDouble = squaredList.stream().map(x->x*x).collect(Collectors.toList());

        List<Integer> squaredAns = squaredList.stream().map(item -> item*item).collect(Collectors.toList());
        System.out.println("请使用 Java Stream 实现对 List 中每个元素进行平方操作:" + squaredAns);

        //6.使用Stream流来完成以下操作 (1)生成id为key ,名称为value的map (2) 获取所有评分大于4.5,菜品包含A,B两类的所有商户的评价数之和
        List<ShangHu> sh = new ArrayList<>();
        sh.add(new ShangHu("1","商户A",5, Arrays.asList("A1","B1"),10));
        sh.add(new ShangHu("2","商户B",6, Arrays.asList("A2","B3"),20));
        sh.add(new ShangHu("3","商户C",10, Arrays.asList("A4","B5"),1));
        sh.add(new ShangHu("4","商户D",3, Arrays.asList("C6","C7"),5));
        sh.add(new ShangHu("5","商户E",7, Arrays.asList("D1","E1"),6));

        Map<String,String> dd = sh.stream().collect(Collectors.toMap(ShangHu::getId,ShangHu::getName));


        Map<String, String> sgMap = sh.stream().collect(Collectors.toMap(ShangHu::getId,ShangHu::getName));
        System.out.println("生成id为key ,名称为value的map:" + sgMap);
        System.out.println("===============================");

        int count = sh.stream().filter(x->x.getPingFen() > 4.5).filter(x->x.getCaiPin().stream().anyMatch(c->c.startsWith("A")))
                .filter(x->x.getCaiPin().stream().anyMatch(c->c.startsWith("B"))).mapToInt(ShangHu::getPingJiaShu).sum();

        int sum = sh.stream().filter(i->i.getPingFen() > 4.5)
                .filter(i-> i.getCaiPin().stream().anyMatch(v->v.startsWith("A")))
                .filter(i->i.getCaiPin().stream().anyMatch(v->v.startsWith("B"))).mapToInt(ShangHu::getPingFen).sum();
        System.out.println("获取所有评分大于4.5,菜品包含A,B两类的所有商户的评价数之和:" + sum);

        //7.计算List<Integer>中所有偶数的平均值
        List<Integer> avgList = Arrays.asList(1,2,3,4,5,6);
        double aavv = avgList.stream().filter(x->x % 2 == 0).mapToInt(x->x).average().orElse(0.0);

        double avg = avgList.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).average().orElse(0.0);
        System.out.println("计算List<Integer>中所有偶数的平均值:" + avg);

        //8. 将List<String>中的字符串连接成一个单独的字符串，并用逗号分隔
        List<String> buildList = Arrays.asList("a","b","c","d","e");
        String bbb = buildList.stream().collect(Collectors.joining(","));

        String buildString = buildList.stream().collect(Collectors.joining(","));
        System.out.println("将List<String>中的字符串连接成一个单独的字符串，并用逗号分隔:" + buildString);

        //9. 将List<Employee>中的年龄进行排序，并输出排序后的员工列表
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1,10));
        emp.add(new Employee(2,1));
        emp.add(new Employee(3,30));
        List<Employee> ages = emp.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());

        List<Employee> age = emp.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList());
        System.out.println("将List<Employee>中的年龄进行排序，并输出排序后的员工列表:" + age);

        //10.将List<Integer>中的元素拼接成一个由逗号分隔的字符串，并去重
        List<Integer> reDupli = Arrays.asList(1,2,3,3,4,5);
        String cxcxc = reDupli.stream().distinct().map(Object::toString).collect(Collectors.joining(","));

        String reString = reDupli.stream().distinct().map(Object::toString).collect(Collectors.joining(","));
        System.out.println("将List<Integer>中的元素拼接成一个由逗号分隔的字符串，并去重:" + reString);

        //11.计算List<Double>中的最大值、最小值、总和以及平均值
        List<Double> doubles = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0);
        double maxx = doubles.stream().mapToDouble(x->x).max().getAsDouble();
        double minn = doubles.stream().mapToDouble(x->x).min().getAsDouble();
        double mix = doubles.stream().mapToDouble(x->x).sum();
        double avvg = doubles.stream().mapToDouble(x->x).average().getAsDouble();

        double max = doubles.stream().mapToDouble(x->x).max().getAsDouble();
        double min = doubles.stream().mapToDouble(x->x).min().getAsDouble();
        double sumDouble = doubles.stream().mapToDouble(x->x).sum();
        double average = doubles.stream().mapToDouble(x->x).average().getAsDouble();
        System.out.println("max:"+max+" min:"+min+" sumDouble:"+ sumDouble+" average:"+ average);

        //定义一个集合，并添加一些整数1,2,3,4,5,6,7,8,9,10，过滤奇数，只留下偶数
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> gn = numbers.stream().filter(x->x % 2 == 0).collect(Collectors.toList());
        System.out.println("gn:" + gn);

        //创建一个ArrayList集合，并添加以下字符串，字符串中前面是姓名，后面是年龄
        //"zhangsan，23"|"lisi，24"|"wangwu，25"
        //保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值
        List<String> nameString = Arrays.asList("zhangsan，23","lisi，24","wangwu，25");
        Map<String,Integer> users = nameString.stream().filter(x-> Integer.valueOf(x.split("，")[1]) >= 24)
                .collect(Collectors.toMap(x->x.split("，")[0],y->Integer.valueOf(y.split("，")[1])));
        System.out.println("users:" + users);

        //现在有两个ArrayList集合，
        //第一个集合中:存储6名男演员的名字和年龄。第二个集合中:存储6名女演员的名字和年龄。
        //姓名和年龄中间用逗号隔开。比如:张三,23要求完成如下的操作:
        //1，男演员只要名字为3个字的前两人2，女演员只要姓杨的，并且不要第一个
        //3，把过滤后的男演员姓名和女演员姓名合并到一起4，将上一步的演员信息封装成Actor对象。
        //5，将所有的演员对象都保存到List集合中。
        //备注:演员类Actor，属性只有一个: name,age

        ArrayList<String> manList = new ArrayList<>();
        ArrayList<String> womenList = new ArrayList<>();
        Collections.addAll(manList,"蔡坤坤,24","叶齁咸,23","刘不甜,22","吴签,24","谷嘉,30","肖梁梁,27");
        Collections.addAll(womenList,"赵小颖,35","杨颖,36","高元元,43","张天天,31","刘诗,35","杨小幂,33");

        Stream<String> manActors = manList.stream().filter(x->x.split(",")[0].length() == 3).limit(2);
        Stream<String> womanActors = womenList.stream().filter(x->x.split(",")[0].startsWith("杨")).skip(1);
//
        List<Actor> actors = Stream.concat(manActors,womanActors)
                .map(x->new Actor(x.split(",")[0],Integer.valueOf(x.split(",")[1]))).collect(Collectors.toList());
        System.out.println("actors:" + actors);
    }

}
