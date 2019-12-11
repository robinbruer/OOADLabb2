package se.iths.robin.Presenter;

import se.iths.robin.Model.IAstronaut;
import se.iths.robin.Repository.AstronautDataSource;

public class AstronautPresenter {

    private AstronautDataSource astronautDataSource;

    public AstronautPresenter(AstronautDataSource astronautDataSource) {
        this.astronautDataSource = astronautDataSource;
    }

    public IAstronaut getAstronauts() {
        return astronautDataSource.getAstronauts();
    }
}
