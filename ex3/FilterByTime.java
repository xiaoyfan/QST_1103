package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		String filePath = "C:/Users/admin/Desktop/access.log";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		while (scanner.hasNext()){
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
			String[] str = line.split(" ");
			String strIp = null;
			String strTime = null;
			String strTime1=null;
			// 对在时间区间内的数据进行输出
			strIp = str[0];
			strTime = str[3];
			strTime1 = strTime.substring(1);
			
			Date date = new Date();
			Locale locale = Locale.US; 
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale.ENGLISH);
			date = df.parse(strTime1);
			if (date.after(beginDate)&&date.before(endDate)){//判断在时间区间内
				System.out.println(strIp + "\t" + strTime1);				
			}
		}
	}
	
}
