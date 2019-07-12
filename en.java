 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class en extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception{
 
        StackPane root = new StackPane();
        PieChart chart = new PieChart();
        ObservableList<PieChart.Data> series = FXCollections.observableArrayList();
        //ここにパイシートのデータを入れていく自動で動かせれば最高
        series.addAll(
                new PieChart.Data("ご飯", 15),
                new PieChart.Data("旅行", 15),
                new PieChart.Data("生活用品", 6.782)
//                new PieChart.Data("服", 4.909),
//                new PieChart.Data("a", 3.664),
//                new PieChart.Data("b", 2.530),
//                new PieChart.Data("c", 2.342),
//                new PieChart.Data("d", 2.062),
//                new PieChart.Data("e", 1.899),
//                new PieChart.Data("f", 1.821),
//                new PieChart.Data("g", 1.806),
//                new PieChart.Data("h", 1.783),
//                new PieChart.Data("i", 10.065)
        );
        //seriesに入ったデータを貼り付ける
        chart.setData(series);
        chart.setTitle("Graph");
        //グラフからの距離
        chart.setLabelLineLength(10);
        //ラベルの位置を決める
        chart.setLegendSide(Side.LEFT);
        root.getChildren().add(chart);
 
        primaryStage.setTitle("円グラフ");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

        
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
