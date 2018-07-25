package eg.oop.comparatorDemo_1;

import java.text.DecimalFormat;  
import java.text.SimpleDateFormat;  
import java.util.GregorianCalendar;  
import java.util.Iterator;  
import java.util.TreeMap;

/** 
 * ��ʵ���� 
 *  
 * @author *
 *  
 */  
@SuppressWarnings("rawtypes")
public class Book implements Comparable { // ������ΪBook���࣬Ĭ�ϼ̳���Object��  
    public int id;// ���  
    public String name;// ����  
    public double price; // �۸�  
    private String author;// ����  
    public GregorianCalendar calendar;// ��������  
  
    public Book() {  
        this(0, "X", 0.0, new GregorianCalendar(), "");  
    }  
  
    public Book(int id, String name, double price, GregorianCalendar calender,  
            String author) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
        this.calendar = calender;  
        this.author = author;  
    }  
  
    // ��д�̳��Ը���Object�ķ���������Book����Ϣ������Ҫ��  
    public String toString() {  
        String showStr = id + "\t" + name; // ������ʾ����Ϣ���ַ���  
        DecimalFormat formatPrice = new DecimalFormat("0.00");// ��ʽ���۸�С�������λ  
        showStr += "\t" + formatPrice.format(price);// ��ʽ���۸�  
        showStr += "\t" + author;  
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy��MM��dd��");  
        showStr += "\t" + formatDate.format(calendar.getTime()); // ��ʽ��ʱ��  
        return showStr; // ��������Ϣ�ַ���  
    }  
  
    public int compareTo(Object obj) {// Comparable�ӿ��еķ���  
        Book b = (Book) obj;  
        return this.id - b.id; // �����id�Ƚϴ�С������Ĭ������  
    }  
  
    @SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {  
        Book b1 = new Book(10000, "��¥��", 150.86, new GregorianCalendar(2009,  
                01, 25), "��ѩ�ۡ��߶�");  
        Book b2 = new Book(10001, "��������", 99.68, new GregorianCalendar(2008, 7,  
                8), "�޹��� ");  
        Book b3 = new Book(10002, "ˮ䰴�", 100.8, new GregorianCalendar(2009, 6,  
                28), "ʩ���� ");  
        Book b4 = new Book(10003, "���μ�", 120.8, new GregorianCalendar(2011, 6,  
                8), "��ж�");  
        Book b5 = new Book(10004, "�����˲�", 10.4, new GregorianCalendar(2011, 9,  
                23), "�Ѻ�");  
        TreeMap tm = new TreeMap();  
        tm.put(b1, new Integer(255));  
        tm.put(b2, new Integer(122));  
        tm.put(b3, new Integer(688));  
        tm.put(b4, new Integer(453));  
        tm.put(b5, new Integer(40));  
        Iterator it = tm.keySet().iterator();  
        Object key = null, value = null;  
        Book bb = null;  
        while (it.hasNext()) {  
            key = it.next();  
            bb = (Book) key;  
            value = tm.get(key);  
            System.out.println(bb.toString() + "\t��棺" + tm.get(key));  
        }  
    }  
}  