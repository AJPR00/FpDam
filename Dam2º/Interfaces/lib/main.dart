import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          padding: EdgeInsetsDirectional.all(50),
          color: Colors.grey[200], // Fondo de color para el Stack
          child: Stack(
            children: [
              Align(
                alignment: Alignment.topLeft,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.black,
                  child: Center(child: Text('Top Left')),
                ),
              ),
              Align(
                alignment: Alignment.topRight,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.black,
                  child: Center(child: Text('Top Right')),
                ),
              ),
              Align(
                alignment: Alignment.bottomLeft,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.black,
                  child: Center(child: Text('Bottom Left')),
                ),
              ),
              Align(
                alignment: Alignment.bottomRight,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.black,
                  child: Center(child: Text('Bottom Right')),
                ),
              ),
              Align(
                alignment: Alignment.centerLeft,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.black,
                  child: Center(child: Text('Center Left')),
                ),
              ),
              Align(
                alignment: Alignment.centerRight,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.black,
                  child: Center(child: Text('Center Right')),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
