package com.fynes.greve.spi;

import com.fynes.greve.Constants;
import com.fynes.greve.model.Person;
import com.fynes.greve.repository.PeopleRepository;
import com.fynes.greve.repository.PeopleRepositoryImpl;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.UnauthorizedException;

import java.util.List;


@Api(name = "person", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
        Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "API for the Person API")
public class PersonApi {

    private PeopleRepository peopleRepository;

    public PersonApi() {
        this.peopleRepository = new PeopleRepositoryImpl();
    }

    @ApiMethod(name= "listAllPeople", path="people", httpMethod = HttpMethod.GET)
    public List<Person> getPeople(){
        return this.peopleRepository.list();
    }

    // TODO : Form data with extra info
    @ApiMethod(name="savePerson", path="person", httpMethod = HttpMethod.POST)
    public void savePerson(User user) throws UnauthorizedException {
        if(user == null){
            throw new UnauthorizedException("User is not logged in!");
        }

        String name = getNameFromEmail(user.getEmail());
        String email = user.getEmail();
        String id = user.getId();

        this.peopleRepository.save(new Person(id, name, email));
    }

    @ApiMethod(name="getPerson", path = "person", httpMethod = HttpMethod.GET)
    public Person getPerson(User user){
        return this.peopleRepository.get(user.getId());
    }





    private String getNameFromEmail(String email) {
        return email == null ? null : email.substring(0, email.indexOf("@"));
    }

}
