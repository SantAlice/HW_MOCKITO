import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    @Test
    public void findAllTest() { //Тестируем пустой массив
        FilmManager manager = new FilmManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAndFindAllTest() { //Тестируем мнимальные пограничные значения
        FilmManager manager = new FilmManager();

        manager.add("Film 1");

        String[] expected = {"Film 1"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addAndFindAllTestEquivalent() { //Тестируем мнимальные пограничные значения и add
        FilmManager manager = new FilmManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    /* @Test
     public void addTest() {
         FilmManager manager = new FilmManager();

         manager.findAll("Film 1");

         String[] expected = {};
         String[] actual = manager.add();
         Assertions.assertArrayEquals(expected, actual);
     } */ //Вспомнила что add ничего не возвращает
    @Test
    public void findLastTest() {
        FilmManager manager = new FilmManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        String[] expected = {"Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTestOverlimit() { //Тестируем превышение лимита по умолчанию
        FilmManager manager = new FilmManager();

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");

        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTestOverlimit7() { //Тестирем выставлениелимита вручную, случай превышения лимита
        FilmManager manager = new FilmManager(7);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");
        manager.add("Film 8");
        manager.add("Film 9");

        String[] expected = {"Film 9", "Film 8", "Film 7", "Film 6", "Film 5", "Film 4", "Film 3"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTestLimit() { //Тестируем выставление парамента limit
        FilmManager manager = new FilmManager(3);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTestUnderLimit() { //Тестируем число меньше лимита
        FilmManager manager = new FilmManager(6);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

}