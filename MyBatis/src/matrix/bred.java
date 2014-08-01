package matrix;

		public class bred {

	class Cell {

	    /**

	     * Создает клетку с координатами x, y.

	     * @param blocked является ли клетка непроходимой

	     */

	    public Cell(int x, int y, boolean blocked) {

	        this.x = x;

	        this.y = y;

	        this.blocked = blocked;

	    }
	    /**

	     * Функция вычисления манхеттенского расстояния от текущей

	     * клетки до finish

	     * @param finish конечная клетка

	     * @return расстояние

	     */

	    public int mandist(Cell finish) {

	        return 10 * (Math.abs(this.x - finish.x) + Math.abs(this.y - finish.y));

	    }
	    /**

	     * Вычисление стоимости пути до соседней клетки finish

	     * @param finish соседняя клетка

	     * @return 10, если клетка по горизонтали или вертикали от текущей, 14, если по диагонали

	     * (это типа 1 и sqrt(2) ~ 1.44)

	     */

	    public int price(Cell finish) {
	        if (this.x == finish.x || this.y == finish.y) {
	            return 10;
	        } else {
	            return 14;
	        }
	    }
	    /**

	     * Устанавливает текущую клетку как стартовую

	     */
	    public void setAsStart() {
	        this.start = true;
	    }
	    /**

	     * Устанавливает текущую клетку как конечную

	     */

	    public void setAsFinish() {

	        this.finish = true;
	    }

	    /**

	     * Сравнение клеток

	     * @param second вторая клетка

	     * @return true, если координаты клеток равны, иначе - false

	     */

	    public boolean equals(Cell second) {

	        return (this.x == second.x) && (this.y == second.y);

	    }

	    /**

	     * Красиво печатаем

	     * * - путь (это в конце)

	     * + - стартовая или конечная

	     * # - непроходимая

	     * . - обычная

	     * @return строковое представление клетки

	     */

	    @Override
		public String toString() {

	        if (this.road) {
	            return " * ";
	        }
	        if (this.start || this.finish) {
	            return " + ";
	        }
	        if (this.blocked) {
	            return " # ";
	        }
	        return " . ";
	    }

	    public int x = -1;

	    public int y = -1;

	    public Cell parent = this;

	    public boolean blocked = false;

	    public boolean start = false;

	    public boolean finish = false;

	    public boolean road = false;

	    public int F = 0;

	    public int G = 0;

	    public int H = 0;

	}



	class Table<T extends Cell> {

	    /**

	     * Создаем карту игры с размерами width и height

	     */

	    public Table(int width, int height) {

	        this.width = width;

	        this.height = height;

	        this.table = new Cell[width][height];

	        for (int i = 0; i < width; i++) {

	            for (int j = 0; j < height; j++) {

	                table[i][j] = new Cell(0, 0, false);

	            }

	        }

	    }



	    /**

	     * Добавить клетку на карту

	     */

	    public void add(Cell cell) {

	        table[cell.x][cell.y] = cell;

	    }



	    /**

	     * Получить клетку по координатам x, y

	     * @return клетка, либо фейковая клетка, которая всегда блокирована (чтобы избежать выхода за границы)

	     */

	    @SuppressWarnings("unchecked")

	    public T get(int x, int y) {

	        if (x < width && x >= 0 && y < height && y >= 0) {

	            return (T)table[x][y];

	        }

	        // а разве так можно делать в Java? оО но работает оО

	        return (T)(new Cell(0, 0, true));

	    }



	    /**

	     * Печать всех клеток поля. Красиво.

	     */

	    public void printp() {

	        for (int i = 0; i < AStar.WIDTH; i++) {

	            for (int j = 0; j < AStar.HEIGHT; j++) {

	                System.out.print(this.get(j, i));

	            }

	            System.out.println();

	            System.out.println();

	        }

	        System.out.println();

	        System.out.println();

	    }



	    public int width;

	    public int height;

	    private final Cell[][] table;

	}



 class AStar {

	    public static final int WIDTH = 10;

	    public static final int HEIGHT = 10;
}
	}
