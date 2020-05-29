# Projeto IBGE
[![Build Status](https://travis-ci.org/hugo-feijo/consultaIbge.svg?branch=master)](https://travis-ci.org/hugo-feijo/consultaIbge)
[![codecov](https://codecov.io/gh/hugo-feijo/consultaIbge/branch/master/graph/badge.svg)](https://codecov.io/gh/hugo-feijo/consultaIbge)

### Objetivo
**Do software**: Consultar a API do ibge e retornar todos os municípios do Brasil.


### Como funciona
A aplicação está rodando no heroku atravez do link  https://consulta-ibge.herokuapp.com/ e possui 3 endpoints

* '/json' : Retornar um JSON de todos municípios da Brasil. 
* '/csv' : Retorna um CSV de todos municípios do Brasil.
* '/{nomeCidade}': Aceita como parametro um nome de uma cidade, e ira buscar os dados dela.