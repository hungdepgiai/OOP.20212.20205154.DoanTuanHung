package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
String filename="test.exe";
byte[]inputBytes= {0};
long startTime = 0,endTime;
inputBytes=Files.readAllBytes(Paths.get(filename));
StringBuilder outputStringBuilder=new StringBuilder();
for(byte b:inputBytes) {
	outputStringBuilder.append((char)b);
}
endTime=System.currentTimeMillis();
System.out.println(endTime-startTime);
}

}
