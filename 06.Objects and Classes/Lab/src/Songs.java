import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    String typeList;
    String name;
    String time;

    public Songs(String typeList, String name, String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(sc.nextLine());
        List<Songs> songs = new ArrayList<>();


        for (int i = 0; i < numberOfSongs; i++) {
            String[] data = sc.nextLine().split("_");

            String typeList = data[0];
            String name = data[1];
            String time = data[2];

            Songs song = new Songs(typeList, name, time);
            songs.add(song);

        }

        String typeListSearch = sc.nextLine();

        if (typeListSearch.equals("all")) {
            for (Songs song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songs) {
                if (song.getTypeList().equals(typeListSearch)) {
                    System.out.println(song.getName());
                }
            }
        }
    }

    public String getTypeList() {
        return typeList;
    }

    public String getName() {
        return name;
    }
}
