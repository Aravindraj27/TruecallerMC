package com.gar.TruecallerMC.model.common;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import orestes.bloomfilter.CountingBloomFilter;
import orestes.bloomfilter.FilterBuilder;

import java.nio.charset.Charset;

import static com.gar.TruecallerMC.model.common.Constants.MAX_COUNT_TO_MARK_GLOBAL_BLOCKED;
import static com.gar.TruecallerMC.model.common.Constants.MAX_GLOBAL_SPAM_COUNT;

public class GlobalSpam {
    private BloomFilter<String> globalBlocked = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")),
            MAX_GLOBAL_SPAM_COUNT);

    private CountingBloomFilter<String> globalSpam = new FilterBuilder(MAX_GLOBAL_SPAM_COUNT, 0.01)
            .buildCountingBloomFilter();
    private GlobalSpam() {

    }
    public static GlobalSpam INSTANCE = new GlobalSpam();

    public void reportSpam(String spamNumber, String reportingNumber, String reason) {
        System.out.println("Send metrics  here for spam number "
                + spamNumber + " reported " + reportingNumber +" for reason " + reason);
        if(globalSpam.getEstimatedCount(spamNumber) >= MAX_COUNT_TO_MARK_GLOBAL_BLOCKED) {
            globalBlocked.put(spamNumber);
        } else {
            globalSpam.add(spamNumber);
        }
    }
    public boolean isGlobalSpam(String number) {
        return globalSpam.contains(number);
    }

    public boolean isGloballyBlocked(String number) {
        return globalBlocked.mightContain(number);
    }
}
