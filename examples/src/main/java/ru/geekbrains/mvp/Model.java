package ru.geekbrains.mvp;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Model {
    Variants variants = new Variants();
    private String prediction = null;

     List<String> source = variants.getVariants();
    int elementCount = 1;
    public void predicting() {
        var random = new SecureRandom();
        var list = new ArrayList<>(source);
        for (int i = 0; i < elementCount; i++) {
            int randomIndex = random.nextInt(list.size());
             prediction = list.get(randomIndex);
            System.out.println(prediction);
            list.remove(randomIndex);

        }

    }

    public String getPrediction() {
        return prediction;}

}
