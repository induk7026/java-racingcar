package racing_game;

import racing_game.domain.Cars;
import racing_game.util.RandomUtil;
import racing_game.view.ResultView;

public class RacingEvent {

    Cars cars;
    int count;
    int round;
    private final ResultView resultView = new ResultView();

    public RacingEvent(Cars cars, int tryCont) {
        this.cars = cars;
        this.count = tryCont;
    }

    public void startEvent(){
        resultView.resultStart();
        for (int round = 0; count > round; round++){
            this.round++;
            start();
        }
        finish();
    }

    public void start(){
        cars.getCars().forEach(car -> {
            car.tryMove(RandomUtil.random());
            resultView.resultView(car);
        });
    }

    public void finish(){
        resultView.showWinner(cars.winner().getWinners());
    }
}
