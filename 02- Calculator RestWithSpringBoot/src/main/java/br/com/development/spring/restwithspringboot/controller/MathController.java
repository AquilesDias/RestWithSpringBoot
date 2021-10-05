package br.com.development.spring.restwithspringboot.controller;

import br.com.development.spring.restwithspringboot.exception.MathException;
import br.com.development.spring.restwithspringboot.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.development.spring.restwithspringboot.converter.NumberConverter.convertDouble;
import static br.com.development.spring.restwithspringboot.converter.NumberConverter.isNumeric;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    //Soma
    @RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new MathException("Please set a numeric value");
        }

       return math.sum(convertDouble(numberOne), convertDouble(numberTwo));
   }

    //Subtração
    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

       if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
           throw new MathException("Please set a numeric value");
       }

       return math.subtration(convertDouble(numberOne), convertDouble(numberTwo));
   }

    //Multiplicação
    @RequestMapping(value = "mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new MathException("Please set a numeric value");
        }

        return math.multiplication(convertDouble(numberOne), convertDouble(numberTwo));
    }

    //Divisão
    @RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

       if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
           throw new MathException("Please set a numeric value");
       }

       return math.division(convertDouble(numberOne), convertDouble(numberTwo));
   }

    //Média
    @RequestMapping(value = "med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

       if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
           throw new MathException("Please set a numeric value");
       }

     return math.mean(convertDouble(numberOne), convertDouble(numberTwo));
   }

    //Raiz Quadrada
    @RequestMapping(value = "raizq/{numberOne}", method = RequestMethod.GET)
    public Double raizQ(@PathVariable("numberOne") String numberOne) throws Exception {

        if(!isNumeric(numberOne)){
            throw new MathException("Please set a numeric value");
        }

        return math.square(convertDouble(numberOne));
    }


}
