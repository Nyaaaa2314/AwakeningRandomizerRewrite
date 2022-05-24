@echo off
rem deleting all bins and lz


cd %~dp0\romfs\data
del *.bin
del *.lz

cd %~dp0\romfs\data\dispos
del *.bin
del *.lz
cd ..

cd %~dp0\romfs\data\person
del *.bin
del *.lz
cd ..
cd ..
cd ..
@echo off

rem set a = 0

FOR %%y IN (romfs\scripts\*.cmb) DO CALL :func %%y, %~dp0



:func
java -jar exd.jar -o %~n1.exl %~2%~1
rem this produces extra unneeded files that are cleaned
rem in the program itself
EXIT /B 0
