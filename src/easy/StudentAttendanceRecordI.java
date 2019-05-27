package easy;

/**
 * @Description: A student could be rewarded if his attendance record doesn't
 *               contain more than one 'A' (absent) or more than two continuous
 *               'L' (late).
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/3/14 0014 16:45
 */
public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		if (s.length() == 0 || s == null) {
			return false;
		}
		int countA = 0;
		int countL = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A' && ++countA > 1) {
				return false;
			}
			if (s.charAt(i) == 'L') {
				if (++countL > 2) {
					return false;
				}
			} else {
				countL = 0;
			}
		}
		return true;
	}
}
