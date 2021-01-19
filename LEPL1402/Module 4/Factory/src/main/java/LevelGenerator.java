public class LevelGenerator {
    public static class ElementFactory extends Factory {
        private static final ElementFactory currentElementFactory = new ElementFactory();

        private ElementFactory() {}

        public static ElementFactory getInstance() {
            return currentElementFactory;
        }

        @Override
        public LevelComponent getElement(char c) {
            switch(c) {
                case 'D':
                    return new Door();
                case '-':
                    return new Floor();
                case 'K':
                    return new Key();
                case '#':
                    return new Wall();
                default:
                    throw new IllegalArgumentException();
            }
        }
    }


    public class Level extends AbstractLevel {
        public Level(String input) {
            String[] elements = input.split("\n");
            size = elements.length;
            components = new LevelComponent[size][size];
            ElementFactory ef = ElementFactory.getInstance();

            for (int i = 0; i < size; i++){
                String elem = elements[i];
                for (int j = 0; j < size; j++) {
                    char c = elem.charAt(j);
                    components[i][j] = ef.getElement(c);
                }
            }
        }

        @Override
        public String toString() {
            String str = "";
            for (LevelComponent[] i : components){
                for (LevelComponent j : i) {
                    str += j.draw();
                }
                str += "\n";
            }
            return str;
        }

        @Override
        public LevelComponent[][] getComponents() {
            return this.components;
        }

        @Override
        public int getSize() {
            return this.size * this.size;
        }
    }
}
