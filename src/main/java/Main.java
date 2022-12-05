public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 9, 12, 15};
        int key = 9;
        System.out.println(binarySearch(arr, key, 0, arr.length - 1));

        System.out.println();
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    static int binarySearch(int[] arr, int key, int start, int end) {
        int middle = (end + start) / 2;
        if (end < start) return -1;
        if (key < arr[middle]) return binarySearch(arr, key, start, end - 1);
        if (key > arr[middle]) return binarySearch(arr, key, middle + 1, end);
        if (key == arr[middle]) return middle;
        return -1;
    }

//    процедура "Перенести" (A, B, C, N)
//    начало
//    если N=1
//    // Если диск всего один, то надо его перенести напрямую
//    то
//    снять диск со стержня A и положить на стержень B;
//    возврат из процедуры;
//    иначе
//        // Переносим все диски, кроме самого большого со стежня
//        // A на стержень C
//    Перенести (A,C,B,N-1);
//    // Переносим самый большой диск со стержня A на стержень B
//    снять диск со стержня A и положить на стержень B;
//    // Переносим все диски со стержня C на стержень B поверх
//    // самого большого диска
//    Перенести (B,A,C,N-1);
//    возврат из процедуры;
//    конец если;
//    конец процедуры "Перенести";

    public static void moveRing(char a, char b, char c, int count) {
        if(count == 0) return;
        if (count == 1) {
            System.out.println(String.format("from %s to %s", a, b));
        } else {
            moveRing(a, c, b, count - 1);
            System.out.println(String.format("from %s to %s", a, b));
            moveRing(c, b, a, count - 1);
        }
    }
}