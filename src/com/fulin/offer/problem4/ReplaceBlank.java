package com.fulin.offer.problem4;

/**
 * 实现一个函数 把字符串的中的所有空格替换为%20
 *
 * 例如： We are Happy.
 * 输出：We%20are%20Happy.
 * @author mfl4482
 *
 */
public class ReplaceBlank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "We are Happy.";
		String target = "%20";
		char[] strArray = str.toCharArray();
		strArray = replaceBlank(strArray, target);
		System.out.println(new String(strArray));
	}

	public static char[] replaceBlank(char[] str ,String target){
		if(str == null || str.length == 0){
			return null;
		}
		int length = 0;
		if(target == null || target.length() == 0){
			// 删除所有的空格
			length = 0;
		}else{
			length = target.length();
		}
		int count = 0;
		int lastIndex = 0;
		for(int i=0;i<str.length;i++){
			if(str[i] == ' '){
				count++;
				lastIndex =i;
			}
		}
		int oldLength = str.length;
		int newLength = oldLength + count *(length - 1);
		if(newLength > str.length){
			char[] temp = str;
			str = new char[newLength];
			System.arraycopy(temp, 0, str, 0,temp.length);
		}

		int copyLength = oldLength - lastIndex - 1;
		int updateIndex = newLength - copyLength;
		System.arraycopy(str, lastIndex + 1, str, updateIndex , copyLength);
		copyLength = target.length();
		updateIndex = updateIndex - copyLength;
		System.arraycopy(target.toCharArray(), 0, str, updateIndex, target.length());
		for(int i = lastIndex -1 ; i>=0;i--){
			if(str[i] == ' '){
				copyLength = lastIndex - i -1;
				updateIndex = updateIndex - copyLength;
				System.arraycopy(str, i + 1, str, updateIndex, copyLength);
				copyLength = target.length();
				updateIndex = updateIndex - copyLength;
				System.arraycopy(target.toCharArray(), 0, str, updateIndex, target.length());
				lastIndex = i;
			}
		}
		return str;
	}
}