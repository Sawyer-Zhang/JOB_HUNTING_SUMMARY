package easy;

/**
 * 
 * @description canConstruct("a", "b") -> false canConstruct("aa", "ab") ->
 *              false canConstruct("aa", "aab") -> true
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月19日
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] alphabet = new int[26];
		char[] magazineArray = magazine.toCharArray();
		for (int j = 0; j < magazineArray.length; j++) {
			alphabet[magazineArray[j] - 'a']++;
		}
		char[] ransomNoteArray = ransomNote.toCharArray();
		for (int i = 0; i < ransomNoteArray.length; i++) {
			if (--alphabet[ransomNoteArray[i] - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}