package se.iths.robin;

import se.iths.robin.ViewModel.MainViewModel;


public class Main {
    private static MainViewModel mainViewModel = new MainViewModel();

    public static void main(String[] args) {
        mainViewModel.present();
    }


}
