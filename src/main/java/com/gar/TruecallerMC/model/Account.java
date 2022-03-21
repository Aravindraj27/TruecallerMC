package com.gar.TruecallerMC.model;

import com.gar.TruecallerMC.model.common.Contact;
import com.gar.TruecallerMC.model.common.PersonalInfo;
import com.gar.TruecallerMC.model.common.SocialInfo;
import com.gar.TruecallerMC.model.common.Tag;
import orestes.bloomfilter.CountingBloomFilter;

import java.time.LocalDateTime;
import java.util.Set;

public class Account {
    private String Id;
    private String phoneNumber;
    private String unserName;
    private String password;
    private LocalDateTime lastSeen;
    private Tag tag;
    private Contact contact;
    private PersonalInfo personalInfo;
    private SocialInfo socialInfo;
    private Business business;
    private UserCategory usercategory;
    private Map<String, User>  contacts;
    private CountingBloomFilter<String> blockedContacts;
    private Set<String> blockedSet;
    private ContactTrie contactTrie;
}
