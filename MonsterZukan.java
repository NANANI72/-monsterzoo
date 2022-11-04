import java.util.ArrayList;
import java.util.List;

public class MonsterZukan {
    String name;
    double rank;
    public MonsterZukan(String name, double rank) {
        this.name = name;
        this.rank = rank;
    }
    
    public static List<MonsterZukan> getmonster() {
        List<MonsterZukan> monstezukan = new ArrayList<>();

        monstezukan.add(new MonsterZukan("イガキン", 9));
        monstezukan.add(new MonsterZukan("ナマチュウ", 3));
        monstezukan.add(new MonsterZukan("イノウエン", 1));
        monstezukan.add(new MonsterZukan("リョージィ", 2));
        monstezukan.add(new MonsterZukan("アキモトン", 5));
        monstezukan.add(new MonsterZukan("ゴージマ", 4));
        monstezukan.add(new MonsterZukan("チュウデン", 6));
        monstezukan.add(new MonsterZukan("ヅカホン", 8));
        monstezukan.add(new MonsterZukan("ニシムラー", 7));
        monstezukan.add(new MonsterZukan("サコーデン", 2));
        monstezukan.add(new MonsterZukan("ウッチー", 5));
        monstezukan.add(new MonsterZukan("ハヤッシー", 4));
        monstezukan.add(new MonsterZukan("キーチー", 3));
        monstezukan.add(new MonsterZukan("リョクン", 1));
        monstezukan.add(new MonsterZukan("デコポン", 6));
        monstezukan.add(new MonsterZukan("カミサン", 5));
        monstezukan.add(new MonsterZukan("シスイ", 1));
        monstezukan.add(new MonsterZukan("ジョナ", 7));
        monstezukan.add(new MonsterZukan("ギダギダ", 2));
        monstezukan.add(new MonsterZukan("ミッツー", 8));
        monstezukan.add(new MonsterZukan("ゾエサン", 5));
        monstezukan.add(new MonsterZukan("キタバー", 3));

        return monstezukan;
    }
}