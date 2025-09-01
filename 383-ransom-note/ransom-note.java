class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] mag = magazine.toCharArray();
        boolean[] used = new boolean[mag.length];

        for (int i = 0; i < ransomNote.length(); i++) {
            char need = ransomNote.charAt(i);
            boolean found = false;
            for (int j = 0; j < mag.length; j++) {
                if (!used[j] && mag[j] == need) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }
}