package No1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		//扫描文本框中的输入
		Scanner scanner = new Scanner(System.in);
		//输入的时间格式
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//输出的时间格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//
		while (scanner.hasNext()){
			//获取输入的一行
			String line = scanner.nextLine();
			//定义一个量的类型为Date
			Date lineDate = null;
			//定义一个量的类型为long
			long lineTimestamp;
			try {
				//转换这个量
				lineDate = inputFormat.parse(line);
				lineTimestamp = lineDate.getTime();
				//输出到结果
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
