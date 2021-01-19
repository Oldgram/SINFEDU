import java.util.List;
import java.awt.Color;
import java.util.Comparator;

public class Sorter {


    /*
     * Should sort the list and order the Flower by color, in this specific order : red, blue, green
     */
    public static void sortFlowerByColor(List<Flower> list){
        class sortFlower implements Comparator<Flower> {
            @Override
            public int compare(Flower f1, Flower f2) {
                return f1.getPetalColor().getRGB() - f2.getPetalColor().getRGB();
            }
        }
        list.sort(new sortFlower());
    }
    /*
     * Should sort the Plant by name only
     */
    public static void sortPlantByName(List<Plant> list){
        class sortPlant implements Comparator<Plant> {
            @Override
            public int compare(Plant p1, Plant p2) {
                String s1 = p1.getName(), s2 = p2.getName();
                for (int i = 0; i < s1.length() && i < s2.length(); i++){
                    int a = s1.charAt(i);
                    int b = s2.charAt(i);
                    if(a < b){
                        return -1;
                    }
                    else if(a > b){
                        return 1;
                    }
                }
                return 0;
            }
        }
        list.sort(new sortPlant());
    }

    /*
     * Should sort the list and order the Tree by height
     */
    public static void sortTreeByHeight(List<Tree> list){
        class sortTree implements Comparator<Tree> {
            @Override
            public int compare(Tree t1, Tree t2) {
                return t1.getHeight() - t2.getHeight();
            }
        }
        list.sort(new sortTree());
    }
}
