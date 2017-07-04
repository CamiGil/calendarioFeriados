# calendarioFeriados
Ejercicio hecho para 10Pines

# Enunciado

La idea es modelar un calendario que permita saber si un día es laborable o no. Por ejemplo, se le debe poder preguntar si el 25 de Diciembre de 2012 es feriado y dependiendo de como esté configurado, responderá si o no.

Se puede configurar el calendario de distintas maneras:
1) Indicándole que un día de la semana es no laborable. Por ejemplo si se le indica que Domingo es feriado, entonces todos los domingos son feriados.
2) Indicándole que un día de un mes es feriado, por ejemplo 25 de Diciembre. Por lo tanto todos los 25 de diciembre sin importar el año son feriados.
3) Indicándole que un día particular es feriado, por ejemplo 4 de Abril de 2012.
Las opciones 1 y 2 indicando un rango de validez del feriado. Por ejemplo: Desde el 1/1/1990 hasta el 31/12/1999 todos los Domingos son feriados, o desde 1/1/2000 hasta 1/1/2013 los 4 de Abril son feriados.

Aclaraciones:
- Desarrollarlo usando TDD.
- No es necesario implementar persistencia, ni interfaz de usuario. Alcanza con los tests necesarios para verificar que la funcionalidad esta correctamente implementada.
- No subir el código a un repositorio público, como GitHub o GitLab.
