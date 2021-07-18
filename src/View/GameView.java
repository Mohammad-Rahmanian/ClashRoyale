package View;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class GameView extends Group {

    private ImageView[][] imageViews;
    public final static double CELL_WIDTH = 20.0;
    private int rowCount = 32;
    private int columnCount = 18;

    public GameView() {

        imageViews = new ImageView[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (((column >= 7 && column <= 10) && ((row >= 1 && row<=4) || (row>=27 && row<=30)))
                        || (((column >= 2 && column <= 4) || (column >= 13 && column <= 15))
                        &&((row >= 5 && row <= 7)|| (row>=24 && row<= 26)) ) ){
                }
                else {
                    Image image;
                    if((column == 3 || column == 14) && (row >=8 && row<=23)){
                        image = new Image(getClass().getResourceAsStream("../Photos/sand.png"));
                    }
                    else {
                        if (row == 15 || row == 16){
                            if (column == 2 || column == 4 || column== 13 || column == 15){
                                image = new Image(getClass().getResourceAsStream("../Photos/sand.png"));
                            }
                            else {
                                image = new Image(getClass().getResourceAsStream("../Photos/water.png"));
                            }
                        }
                        else {
                            if (row == 0 || row == 31){
                                image = new Image(getClass().getResourceAsStream("../Photos/trees.png"));
                            }
                            else {
                                image = new Image(getClass().getResourceAsStream("../Photos/grass.png"));
                            }
                        }
                    }
                    ImageView imageView = new ImageView();

                    imageViews[row][column] = imageView;
                    imageView.setImage(image);
                    imageView.setX(column * CELL_WIDTH);
                    imageView.setY(row * CELL_WIDTH);
                    imageView.setFitWidth(CELL_WIDTH);
                    imageView.setFitHeight(CELL_WIDTH);
                    this.getChildren().add(imageView);
                }
            }
        }
        Image image = new Image(getClass().getResourceAsStream("../Photos/kingTowerRed.jpg"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(7 * CELL_WIDTH);
        imageView.setY(1 * CELL_WIDTH);
        imageView.setFitWidth(4 * CELL_WIDTH);
        imageView.setFitHeight(4 * CELL_WIDTH);
        this.getChildren().add(imageView);


        image = new Image(getClass().getResourceAsStream("../Photos/archerTowerRed.jpg"));
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(2 * CELL_WIDTH);
        imageView.setY(5 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        this.getChildren().add(imageView);



        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(13 * CELL_WIDTH);
        imageView.setY(5 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        this.getChildren().add(imageView);

        image = new Image(getClass().getResourceAsStream("../Photos/kingTowerBlue.jpg"));
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(7 * CELL_WIDTH);
        imageView.setY(27 * CELL_WIDTH);
        imageView.setFitWidth(4 * CELL_WIDTH);
        imageView.setFitHeight(4 * CELL_WIDTH);
        this.getChildren().add(imageView);



        image = new Image(getClass().getResourceAsStream("../Photos/archerTowerBlue.jpg"));
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(2 * CELL_WIDTH);
        imageView.setY(24 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        this.getChildren().add(imageView);

        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(13 * CELL_WIDTH);
        imageView.setY(24 * CELL_WIDTH);
        imageView.setFitWidth(3 * CELL_WIDTH);
        imageView.setFitHeight(3 * CELL_WIDTH);
        this.getChildren().add(imageView);






////                button.setOnMouseDragEntered(this::showFire);
//
//
////                button.setOnMouseDragReleased(this::showFire);
//
//
//
//
//
//
//
//                button.setOnDragDetected(new EventHandler <MouseEvent>() {
//                    public void handle(MouseEvent event) {
//                        /* drag was detected, start drag-and-drop gesture*/
//                        System.out.println("onDragDetected");
//                        Button button = (Button) event.getSource();
//                        button.setGraphic(null);
//
//                        /* allow any transfer mode */
//                        Dragboard db = button.startDragAndDrop(TransferMode.ANY);
//
//                        /* put a string on dragboard */
//                        ClipboardContent content = new ClipboardContent();
//                        content.putString(button.getText());
//                        db.setContent(content);
//
//                        event.consume();
//                    }
//                });
//
//
//
//                button.setOnDragOver(new EventHandler <DragEvent>() {
//                    public void handle(DragEvent event) {
//                        /* data is dragged over the target */
//                        System.out.println("onDragOver");
//
//                        /* accept it only if it is  not dragged from the same node
//                         * and if it has a string data */
//                        if (event.getGestureSource() != button &&
//                                event.getDragboard().hasString()) {
//                            /* allow for both copying and moving, whatever user chooses */
//                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                        }
//
//                        event.consume();
//                    }
//                });
////                button.setOnAction(this::showFire);
////                button.setOnDragDone(new EventHandler <DragEvent>() {
////                    public void handle(DragEvent event) {
////                        /* the drag-and-drop gesture ended */
////                        System.out.println("onDragDone");
////                        /* if the data was successfully moved, clear it */
////                        if (event.getTransferMode() == TransferMode.MOVE) {
////                            button.setText("aaaaaaa");
////                        }
////
////                        event.consume();
////                    }
////                });
////                button.setOnDragEntered(new EventHandler <DragEvent>() {
////                    public void handle(DragEvent event) {
////                        /* the drag-and-drop gesture entered the target */
////                        System.out.println("onDragEntered");
////                        /* show to the user that it is an actual gesture target */
////                        if (event.getGestureSource() != button &&
////                                event.getDragboard().hasString()) {
////                            button.setText("parcham");
////                        }
////
////                        event.consume();
////                    }
////                });
//                button.setOnDragDropped(new EventHandler <DragEvent>() {
//                    public void handle(DragEvent event) {
//                        Button button = (Button) event.getSource();
//                        ImageView imageView = new ImageView();
//                        Image image = new Image(getClass().getResourceAsStream("../Photos/background_blue.png"));
//                        imageView.setImage(image);
//                        imageView.setX(button.getLayoutX());
//                        imageView.setY(button.getLayoutY());
//                        imageView.setFitWidth(CELL_WIDTH);
//                        imageView.setFitHeight(CELL_WIDTH);
//                        button.setGraphic(imageView);
//
//
//
//
//
//
//
//
//
//
//                        /* data dropped */
//                        System.out.println("onDragDropped");
//                        /* if there is a string data on dragboard, read it and use it */
//                        Dragboard db = event.getDragboard();
//                        boolean success = false;
//                        if (db.hasString()) {
//                            button.setText(db.getString());
//                            success = true;
//                        }
//                        /* let the source know whether the string was successfully
//                         * transferred and used */
//                        event.setDropCompleted(success);
//
//                        event.consume();
//                    }
//                });
//                this.getChildren().add(button);
//            }
//        }
//    }
//
//    public void showFire(DragEvent dragEvent)
//    {
//        Dragboard dragboard = dragEvent.getDragboard();
//        dragEvent.setDropCompleted(true);
//        System.out.println("pashmam1");
//    }
//    public  void showFire(MouseEvent mouseEvent) {
//        System.out.println("pashmam2");
//        Button button = (Button) mouseEvent.getSource();
//        button.setGraphic(null);
//        button.setOnDragDropped(this::showFire);
//    }
////    private void showFire(MouseDragEvent mouseDragEvent) {
////        System.out.println("pashmam3");
////        ImageView view = (ImageView)mouseDragEvent.getSource();
////        ImageView imageView = new ImageView();
////        Image image = new Image(getClass().getResourceAsStream("../Photos/background_blue.png"));
////        imageView.setImage(image);
////        imageView.setX(view.getLayoutX());
////        imageView.setY(view.getLayoutY());
////        imageView.setFitWidth(CELL_WIDTH);
////        imageView.setFitHeight(CELL_WIDTH);
////        this.getChildren().add(imageView);
////    }
//
//    @FXML
//    void showFire(ActionEvent event) {
//       Button button = (Button) event.getSource();
//        ImageView imageView = new ImageView();
//        Image image = new Image(getClass().getResourceAsStream("../Photos/background_blue.png"));
//        imageView.setImage(image);
//        imageView.setX(button.getLayoutX());
//        imageView.setY(button.getLayoutY());
//        imageView.setFitWidth(CELL_WIDTH);
//        imageView.setFitHeight(CELL_WIDTH);
//        button.setGraphic(imageView);
//    }



    }

}
