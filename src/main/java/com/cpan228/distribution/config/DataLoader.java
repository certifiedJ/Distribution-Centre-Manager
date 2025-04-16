package com.cpan228.distribution.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cpan228.distribution.data.DistributionCentreItemRepository;
import com.cpan228.distribution.data.DistributionCentreRepository;
import com.cpan228.distribution.data.ItemRepository;
import com.cpan228.distribution.model.DistributionCentreItems;
import com.cpan228.distribution.model.DistributionCentres;
import com.cpan228.distribution.model.Items;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(DistributionCentreRepository dc_repository,
                                      DistributionCentreItemRepository dci_repository,
                                      ItemRepository i_repository) {
        return args -> {
            // Clear existing data
            dc_repository.deleteAll();
            i_repository.deleteAll();
            dci_repository.deleteAll();

            // Add sample distribution centres
            DistributionCentres etobicoke = dc_repository.save(new DistributionCentres(null, "Etobicoke Hub", 43.6205, -79.5132));
            DistributionCentres brampton = dc_repository.save(new DistributionCentres(null, "Brampton Depot", 43.7315, -79.7624));
            DistributionCentres mississauga = dc_repository.save(new DistributionCentres(null, "Mississauga Centre", 43.5890, -79.6441));
            DistributionCentres northYork = dc_repository.save(new DistributionCentres(null, "North York Station", 43.7679, -79.4111));
            DistributionCentres scarborough = dc_repository.save(new DistributionCentres(null, "Scarborough Warehouse", 43.7845, -79.2349));

            // Add sample items
            Items tShirt = i_repository.save(new Items(null, "Cotton T-Shirt", "Nike", 2022, 29.99));
            Items shorts = i_repository.save(new Items(null, "Running Shorts", "Adidas", 2022, 39.99));
            Items jacket = i_repository.save(new Items(null, "Winter Jacket", "North Face", 2023, 199.99));
            Items jeans = i_repository.save(new Items(null, "Denim Jeans", "Levi's", 2022, 79.99));
            Items dress = i_repository.save(new Items(null, "Summer Dress", "H&M", 2023, 59.99));
            Items sweater = i_repository.save(new Items(null, "Wool Sweater", "Gap", 2022, 69.99));
            Items skirt = i_repository.save(new Items(null, "Pleated Skirt", "Zara", 2021, 49.99));
            Items hoodie = i_repository.save(new Items(null, "Fleece Hoodie", "Nike", 2022, 89.99));

            // Add sample DistributionCentreItems
            dci_repository.save(new DistributionCentreItems(etobicoke, tShirt, 150));
            dci_repository.save(new DistributionCentreItems(etobicoke, shorts, 100));
            dci_repository.save(new DistributionCentreItems(etobicoke, jacket, 50));
            dci_repository.save(new DistributionCentreItems(etobicoke, jeans, 200));
            dci_repository.save(new DistributionCentreItems(etobicoke, dress, 75));
            dci_repository.save(new DistributionCentreItems(etobicoke, sweater, 0));

            dci_repository.save(new DistributionCentreItems(brampton, tShirt, 180));
            dci_repository.save(new DistributionCentreItems(brampton, shorts, 90));
            dci_repository.save(new DistributionCentreItems(brampton, jacket, 60));
            dci_repository.save(new DistributionCentreItems(brampton, jeans, 150));
            dci_repository.save(new DistributionCentreItems(brampton, skirt, 40));
            dci_repository.save(new DistributionCentreItems(brampton, hoodie, 110));

            dci_repository.save(new DistributionCentreItems(mississauga, tShirt, 200));
            dci_repository.save(new DistributionCentreItems(mississauga, dress, 80));
            dci_repository.save(new DistributionCentreItems(mississauga, sweater, 30));
            dci_repository.save(new DistributionCentreItems(mississauga, skirt, 50));
            dci_repository.save(new DistributionCentreItems(mississauga, hoodie, 130));
            dci_repository.save(new DistributionCentreItems(mississauga, jeans, 160));

            dci_repository.save(new DistributionCentreItems(northYork, shorts, 120));
            dci_repository.save(new DistributionCentreItems(northYork, jacket, 70));
            dci_repository.save(new DistributionCentreItems(northYork, dress, 90));
            dci_repository.save(new DistributionCentreItems(northYork, sweater, 20));
            dci_repository.save(new DistributionCentreItems(northYork, skirt, 60));
            dci_repository.save(new DistributionCentreItems(northYork, hoodie, 140));

            dci_repository.save(new DistributionCentreItems(scarborough, tShirt, 170));
            dci_repository.save(new DistributionCentreItems(scarborough, shorts, 110));
            dci_repository.save(new DistributionCentreItems(scarborough, jacket, 80));
            dci_repository.save(new DistributionCentreItems(scarborough, jeans, 190));
            dci_repository.save(new DistributionCentreItems(scarborough, dress, 100));
            dci_repository.save(new DistributionCentreItems(scarborough, sweater, 10));
        };
    }
}