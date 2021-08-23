package View;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * The type Game view.
 *
 * @author Mohammad Rahmanian - Mahmood Saneian.
 * @version 1.0
 */
public class GameView extends Group {

    private ImageView[][] imageViews;
    /**
     * The constant CELL_WIDTH.
     */
    public final static double CELL_WIDTH = 20.0;
    private int rowCount = 32;
    private int columnCount = 18;

    /**
     * Instantiates a new Game view.
     */
    public GameView() {

        imageViews = new ImageView[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                ImageView imageView = new ImageView();
                if (((column >= 7 && column <= 10) && ((row >= 1 && row <= 4) || (row >= 27 && row <= 30)))
                        || (((column >= 2 && column <= 4) || (column >= 13 && column <= 15))
                        && ((row >= 5 && row <= 7) || (row >= 24 && row <= 26)))) {
                } else {
                    Image image;
                    if ((column == 3 || column == 14) && (row >= 8 && row <= 23)) {
                        image = new Image(getClass().getResourceAsStream("../Photos/sand.png"));
                        imageViews[row][column] = imageView;
                    } else {
                        if (row == 15 || row == 16) {
                            if (column == 2 || column == 4 || column == 13 || column == 15) {
                                image = new Image(getClass().getResourceAsStream("../Photos/sand.png"));
                                imageViews[row][column] = imageView;
                            } else {
                                image = new Image(getClass().getResourceAsStream("../Photos/water.png"));
                            }
                        } else {
                            if (row == 0 || row == 31) {
                                image = new Image(getClass().getResourceAsStream("../Photos/trees.png"));
                            } else {
                                image = new Image(getClass().getResourceAsStream("../Photos/grass.png"));
                                imageViews[row][column] = imageView;
                            }
                        }
                    }
                    imageView.setImage(image);
                    imageView.setX(column * CELL_WIDTH);
                    imageView.setY(row * CELL_WIDTH);
                    imageView.setFitWidth(CELL_WIDTH);
                    imageView.setFitHeight(CELL_WIDTH);
                    this.getChildren().add(imageView);
                }
            }
        }
    }

    /**
     * Get image views image view [ ] [ ].
     *
     * @return the image view [ ] [ ]
     */
    public ImageView[][] getImageViews() {
        return imageViews;
    }

}



