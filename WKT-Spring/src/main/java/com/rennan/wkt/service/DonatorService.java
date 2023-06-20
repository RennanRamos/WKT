package com.rennan.wkt.service;

import com.rennan.wkt.domain.*;
import com.rennan.wkt.repository.DonatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DonatorService {

    private final DonatorRepository donatorRepository;

    @Autowired
    public DonatorService(DonatorRepository donatorRepository) {
        this.donatorRepository = donatorRepository;
    }

    public void saveDonator(Donator donator) {
        if(donatorRepository.findByCPF(donator.getCpf()).isEmpty()){
            donatorRepository.save(donator);
        }
    }

    public List<EstateQuant> quantByState() {
        List<String> estados = new ArrayList<>(Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
                "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));

        List<EstateQuant> quantPorEstados = new ArrayList<>();

        for (String estado : estados) {
            EstateQuant objetoTemporario = new EstateQuant();
            objetoTemporario.quant = donatorRepository.findByStates(estado);
            objetoTemporario.estado = estado;

            quantPorEstados.add(objetoTemporario);
        }
        return quantPorEstados;
    }

    public List<AgeRangeIMC> imc10A10() {
        List<AgeRangeIMC> imc10A10 = new ArrayList<>();

        Date data = new Date();
        int year = data.getYear();
        int currentYear=year+1900;

        List<Donator> listaTodosDoadores = donatorRepository.findAll();

        long totalPeso30 = 0;
        long totalPeso40 = 0;
        long totalPeso50 = 0;
        long totalPeso60 = 0;
        long totalPeso70 = 0;
        long totalPeso80 = 0;
        long totalPeso90 = 0;

        float totalAltura30 = 0;
        float totalAltura40 = 0;
        float totalAltura50 = 0;
        float totalAltura60 = 0;
        float totalAltura70 = 0;
        float totalAltura80 = 0;
        float totalAltura90 = 0;

        int totalPessoas30 = 0;
        int totalPessoas40 = 0;
        int totalPessoas50 = 0;
        int totalPessoas60 = 0;
        int totalPessoas70 = 0;
        int totalPessoas80 = 0;
        int totalPessoas90 = 0;

        for (Donator donator: listaTodosDoadores) {
            String donatorDataNasc = donator.getData_nasc();
            String ano = donatorDataNasc.substring(donatorDataNasc.length() - 4);
            int idade = currentYear - Integer.valueOf(ano);

            if(idade <= 30 && idade >= 21){
                totalPessoas30 += 1;
                totalPeso30 = totalPeso30 + donator.getPeso();
                totalAltura30 = totalAltura30 + donator.getAltura();
            }

            if(idade <= 40 && idade >= 31){
                totalPessoas40 += 1;
                totalPeso40 = totalPeso40 + donator.getPeso();
                totalAltura40 = totalAltura40 + donator.getAltura();
            }

            if(idade <= 50 && idade >= 41){
                totalPessoas50 += 1;
                totalPeso50 = totalPeso50 + donator.getPeso();
                totalAltura50 = totalAltura50 + donator.getAltura();
            }

            if(idade <= 60 && idade >= 51){
                totalPessoas60 += 1;
                totalPeso60 = totalPeso60 + donator.getPeso();
                totalAltura60 = totalAltura60 + donator.getAltura();
            }

            if(idade <= 70 && idade >= 61){
                totalPessoas70 += 1;
                totalPeso70 = totalPeso70 + donator.getPeso();
                totalAltura70 = totalAltura70 + donator.getAltura();
            }

            if(idade <= 80 && idade >= 71){
                totalPessoas80 += 1;
                totalPeso80 = totalPeso80 + donator.getPeso();
                totalAltura80 = totalAltura80 + donator.getAltura();
            }

            if(idade <= 90 && idade >= 81) {
                totalPessoas90 += 1;
                totalPeso90 = totalPeso90 + donator.getPeso();
                totalAltura90 = totalAltura90 + donator.getAltura();
            }
        }

        AgeRangeIMC objetoTemporario30 = new AgeRangeIMC();
        Long mediaPeso30 = totalPeso30/totalPessoas30;
        Float mediaAltura30 = totalAltura30/totalPessoas30;
        objetoTemporario30.imc = mediaPeso30/(mediaAltura30*mediaAltura30);
        objetoTemporario30.idade = 30;
        imc10A10.add(objetoTemporario30);

        AgeRangeIMC objetoTemporario40 = new AgeRangeIMC();
        Long mediaPeso40 = totalPeso40/totalPessoas40;
        Float mediaAltura40 = totalAltura40/totalPessoas40;
        objetoTemporario40.imc = mediaPeso40/(mediaAltura40*mediaAltura40);
        objetoTemporario40.idade = 40;
        imc10A10.add(objetoTemporario40);

        AgeRangeIMC objetoTemporario50 = new AgeRangeIMC();
        Long mediaPeso50 = totalPeso50/totalPessoas50;
        Float mediaAltura50 = totalAltura50/totalPessoas50;
        objetoTemporario50.imc = mediaPeso50/(mediaAltura50*mediaAltura50);
        objetoTemporario50.idade = 50;
        imc10A10.add(objetoTemporario50);

        AgeRangeIMC objetoTemporario60 = new AgeRangeIMC();
        Long mediaPeso60 = totalPeso60/totalPessoas60;
        Float mediaAltura60 = totalAltura60/totalPessoas60;
        objetoTemporario60.imc = mediaPeso60/(mediaAltura60*mediaAltura60);
        objetoTemporario60.idade = 60;
        imc10A10.add(objetoTemporario60);

        AgeRangeIMC objetoTemporario70 = new AgeRangeIMC();
        Long mediaPeso70 = totalPeso70/totalPessoas70;
        Float mediaAltura70 = totalAltura70/totalPessoas70;
        objetoTemporario70.imc = mediaPeso70/(mediaAltura70*mediaAltura70);
        objetoTemporario70.idade = 70;
        imc10A10.add(objetoTemporario70);

        AgeRangeIMC objetoTemporario80 = new AgeRangeIMC();
        Long mediaPeso80 = totalPeso80/totalPessoas80;
        Float mediaAltura80 = totalAltura80/totalPessoas80;
        objetoTemporario80.imc = mediaPeso80/(mediaAltura80*mediaAltura80);
        objetoTemporario80.idade = 80;
        imc10A10.add(objetoTemporario80);

        AgeRangeIMC objetoTemporario90 = new AgeRangeIMC();
        Long mediaPeso90 = totalPeso90/totalPessoas90;
        Float mediaAltura90 = totalAltura90/totalPessoas90;
        objetoTemporario90.imc = mediaPeso90/(mediaAltura90*mediaAltura90);
        objetoTemporario90.idade = 90;
        imc10A10.add(objetoTemporario90);

        return imc10A10;
    }

    public List<Obesity> obesityByGender() {
        List<Obesity> obesityList = new ArrayList<>();

        String masc = "Masculino";
        String fem = "Feminino";

        List<Donator> mascList = donatorRepository.searchAllBySexoEquals(masc);
        List<Donator> femList = donatorRepository.searchAllBySexoEquals(fem);

        int totalMasc = 0;
        int totalFem = 0;

        for (Donator doador : mascList) {
            float imc = doador.getPeso() / (doador.getAltura() * doador.getAltura());

            if (imc > 30.00){
                totalMasc += 1;
            }
        }
        int porcMasc = (totalMasc*100)/mascList.size();

        for (Donator doador : femList) {
            float imc = doador.getPeso() / (doador.getAltura() * doador.getAltura());

            if (imc > 30.00){
                totalFem += 1;
            }
        }
        int porcFem = (totalFem*100)/femList.size();

        Obesity objetoMasc = new Obesity();
        objetoMasc.genero = masc;
        objetoMasc.por = porcMasc;

        Obesity objetoFem = new Obesity();
        objetoFem.genero = fem;
        objetoFem.por = porcFem;

        obesityList.add(objetoMasc);
        obesityList.add(objetoFem);

        return obesityList;
    }

    public List<BloodTypeQuant> bloodTypeQuant() {
        List<String> tiposSangue = new ArrayList<>(Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"));

        List<BloodTypeQuant> quantPorTipo = new ArrayList<>();

        Date data = new Date();
        int year = data.getYear();
        int currentYear=year+1900;

        for (String tipoSangue : tiposSangue) {
            List<Donator> listaIdade = donatorRepository.allBySangue(tipoSangue);

            int iteracoes = 0;
            int totalIdade = 0;

            for (Donator donator: listaIdade) {
                String donatorDataNasc = donator.getData_nasc();
                String ano = donatorDataNasc.substring(donatorDataNasc.length() - 4);
                int idade = currentYear - Integer.valueOf(ano);

                iteracoes += 1;
                totalIdade = totalIdade + idade;
            }

            BloodTypeQuant objetoTemporario = new BloodTypeQuant();
            objetoTemporario.quant = totalIdade/iteracoes;
            objetoTemporario.bloodType = tipoSangue;

            quantPorTipo.add(objetoTemporario);
        }
        return quantPorTipo;
    }

    public List<BloodTypeQuant> receptorsQuant(){
        List<String> tiposSangue = new ArrayList<>(Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"));
        List<Donator> listaPorPeso = donatorRepository.pesoMaior50();
        List<Donator> listaPorIdade = new ArrayList<>();
        List<BloodTypeQuant> listPre = new ArrayList<>();

        Date data = new Date();
        int year = data.getYear();
        int currentYear=year+1900;

        int contador = 0;

        for (Donator donator: listaPorPeso) {
            String donatorDataNasc = donator.getData_nasc();
            String ano = donatorDataNasc.substring(donatorDataNasc.length() - 4);
            int idade = currentYear - Integer.valueOf(ano);

            if (idade > 16 && idade < 69) {
                listaPorIdade.add(donator);
            }
        }

        for (String sangue : tiposSangue) {
            for (Donator doador : listaPorIdade) {
                if(doador.getTipo_sanguineo().equals(sangue)){
                    contador +=1;
                }
            }
            BloodTypeQuant objetoTemporario = new BloodTypeQuant();
            objetoTemporario.quant = contador;
            objetoTemporario.bloodType = sangue;

            listPre.add(objetoTemporario);
            contador = 0;
        }
        return listPre;
    }
}