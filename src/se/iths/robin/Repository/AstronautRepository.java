package se.iths.robin.Repository;

import se.iths.robin.Model.IAstronaut;
import se.iths.robin.Service.AstronautNetworkService;

public class AstronautRepository implements AstronautDataSource {

    private AstronautNetworkService astronautNetworkService;

    public AstronautRepository() {
        astronautNetworkService = new AstronautNetworkService();
    }

    @Override
    public IAstronaut getAstronauts() {
        return astronautNetworkService.getAstronauts();
    }
}
