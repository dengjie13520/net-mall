import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { GoodModule } from './good/good.module';

@Module({
  imports: [GoodModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
